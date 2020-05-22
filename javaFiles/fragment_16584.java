public class Lights{
    private static final int SIZE = 5;

    private static boolean[] toggle(int i, int j) {
        boolean[] action = new boolean[SIZE*SIZE];
        int idx = i*SIZE+j;
        action[idx] = true;
        if (j > 0)      action[idx-1] = true;
        if (j < SIZE-1) action[idx+1] = true;
        if (i > 0)      action[idx-SIZE] = true;
        if (i < SIZE-1) action[idx+SIZE] = true;
        return action;
    }
    private static boolean[][] matrixA() {
        boolean[][] mat = new boolean[SIZE*SIZE][];
        for(int i = 0; i < SIZE; ++i) {
            for(int j = 0; j < SIZE; ++j) {
                mat[i*SIZE+j] = toggle(i,j);
            }
        }
        return mat;
    }
    private static void rotateR(boolean[] a, int r) {
        r %= a.length;
        if (r < 0) r += a.length;
        if (r == 0) return;
        boolean[] tmp = new boolean[r];
        for(int i = 0; i < r; ++i) {
            tmp[i] = a[i];
        }
        for(int i = 0; i < a.length - r; ++i) {
            a[i] = a[i+r];
        }
        for(int i = 0; i < r; ++i) {
            a[i + a.length - r] = tmp[i];
        }
    }
    private static void rotateR(boolean[][] a, int r) {
        r %= a.length;
        if (r < 0) r += a.length;
        if (r == 0) return;
        boolean[][] tmp = new boolean[r][];
        for(int i = 0; i < r; ++i) {
            tmp[i] = a[i];
        }
        for(int i = 0; i < a.length - r; ++i) {
            a[i] = a[i+r];
        }
        for(int i = 0; i < r; ++i) {
            a[i + a.length - r] = tmp[i];
        }
    }
    private static int count(boolean[] a) {
        int c = 0;
        for(int i = 0; i < a.length; ++i) {
            if (a[i]) ++c;
        }
        return c;
    }
    private static void swapBits(boolean[] a, int i, int j) {
        boolean tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static void addBit(boolean[] a, int i, int j) {
        a[j] ^= a[i];
    }
    private static void swapRows(boolean[][] a, int i, int j) {
        boolean[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static void xorb(boolean[] a, boolean[] b) {
        for(int i = 0; i < a.length; ++i) {
            a[i] ^= b[i];
        }
    }
    private static boolean[] boolBits(int bits, long param) {
        boolean[] bitArr = new boolean[bits];
        for(int i = 0; i < bits; ++i) {
            if (((param >> i) & 1L) != 0) {
                bitArr[i] = true;
            }
        }
        return bitArr;
    }
    private static boolean[] solve(boolean[][] m, boolean[] b) {
        // Move first SIZE rows to bottom, so that on the diagonal
        // above the lowest SIZE rows, there are unit matrices
        rotateR(m, SIZE);
        // modify right hand side accordingly
        rotateR(b,SIZE);
        // clean first SIZE*(SIZE-1) columns
        for(int i = 0; i < SIZE*(SIZE-1); ++i) {
            for(int k = 0; k < SIZE*SIZE; ++k) {
                if (k == i) continue;
                if (m[k][i]) {
                    xorb(m[k], m[i]);
                    b[k] ^= b[i];
                }
            }
        }
        // Now we have a block matrix
        /*
         * E 0 0 ... 0 X
         * 0 E 0 ... 0 X
         * 0 0 E ... 0 X
         * ...
         * 0 0 ... E 0 X
         * 0 0 ... 0 E X
         * 0 0 ... 0 0 Y
         *
         */
        // Bring Y to row-echelon form
        int i = SIZE*(SIZE-1), j, k, mi = i;
        while(mi < SIZE*SIZE){
            // Try to find a row with mi-th bit set
            for(j = i; j < SIZE*SIZE; ++j) {
                if (m[j][mi]) break;
            }
            if (j < SIZE*SIZE) {
                // Found one
                if (j > i) {
                    swapRows(m,i,j);
                    swapBits(b,i,j);
                }
                for(k = 0; k < SIZE*SIZE; ++k) {
                    if (k == i) continue;
                    if (m[k][mi]) {
                        xorb(m[k], m[i]);
                        b[k] ^= b[i];
                    }
                }
                // cleaned up column, good row, next
                ++i;
            }
            // Look at next column
            ++mi;
        }
        printMat(m,b);
        boolean[] best = b;
        if (i < SIZE*SIZE) {
            // We have zero-rows in the matrix,
            // check whether the puzzle is solvable at all,
            // i.e. all corresponding bits in the rhs are 0
            for(j = i; j < SIZE*SIZE; ++j) {
                if (b[j]) {
                    System.out.println("Puzzle not solvable, some lights must remain lit.");
                    break;
//                     throw new IllegalArgumentException("Puzzle is not solvable!");
                }
            }
            // Pretending it were solvable if not
            if (j < SIZE*SIZE) {
                System.out.println("Pretending the puzzle were solvable...");
                for(; j < SIZE*SIZE; ++j) {
                    b[j] = false;
                }
            }
            // Okay, puzzle is solvable, but there are several solutions
            // Let's try to find the one with the least toggles.

            // We have the canonical solution with last bits all zero
            int toggles = count(b);
            System.out.println(toggles + " toggles in canonical solution");
            int freeBits = SIZE*SIZE - i;
            long max = 1L << freeBits;
            System.out.println(freeBits + " free bits");
            // Check all combinations of free bits whether they produce
            // something better
            for(long param = 1; param < max; ++param) {
                boolean[] base = boolBits(freeBits,param);
                boolean[] c = new boolean[SIZE*SIZE];
                for(k = 0; k < freeBits; ++k) {
                    c[i+k] = base[k];
                }
                for(k = 0; k < i; ++k) {
                    for(j = 0; j < freeBits; ++j) {
                        c[k] ^= base[j] && m[k][j+i];
                    }
                }
                xorb(c,b);
                int t = count(c);
                if (t < toggles) {
                    System.out.printf("Found new best for param %x, %d toggles\n",param,t);
                    printMat(m,c,b);
                    toggles = t;
                    best = c;
                } else {
                    System.out.printf("%d toggles for parameter %x\n", t, param);
                }
            }
        }
        return best;
    }
    private static boolean[] parseLights(int[] lights) {
        int lim = lights.length;
        if (SIZE*SIZE < lim) lim = SIZE*SIZE;
        boolean[] b = new boolean[SIZE*SIZE];
        for(int i = 0; i < lim; ++i) {
            b[i] = (lights[i] != 0);
        }
        return b;
    }
    private static void printToggles(boolean[] s) {
        for(int i = 0; i < s.length; ++i) {
            if (s[i]) {
                System.out.print("(" + (i/SIZE + 1) + ", " + (i%SIZE + 1) + "); ");
            }
        }
        System.out.println();
    }
    private static void printMat(boolean[][] a, boolean[] rhs) {
        for(int i = 0; i < SIZE*SIZE; ++i) {
            for(int j = 0; j < SIZE*SIZE; ++j) {
                System.out.print((a[i][j] ? "1 " : "0 "));
            }
            System.out.println("| " + (rhs[i] ? "1" : "0"));
        }
    }
    private static void printMat(boolean[][] a, boolean[] sol, boolean[] rhs) {
        for(int i = 0; i < SIZE*SIZE; ++i) {
            for(int j = 0; j < SIZE*SIZE; ++j) {
                System.out.print((a[i][j] ? "1 " : "0 "));
            }
            System.out.println("| " + (sol[i] ? "1" : "0") + " | " + (rhs[i] ? "1" : "0"));
        }
    }
    private static void printGrid(boolean[] g) {
        for(int i = 0; i < SIZE; ++i) {
            for(int j = 0; j < SIZE; ++j) {
                System.out.print(g[i*SIZE+j] ? "1" : "0");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] initialLights = new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,
                1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0 };
        boolean[] b = parseLights(initialLights);
        boolean[] b2 = b.clone();
        boolean[][] coefficients = matrixA();
        boolean[] toggles = solve(coefficients, b);
        printGrid(b2);
        System.out.println("--------");
        boolean[][] check = matrixA();
        boolean[] verify = new boolean[SIZE*SIZE];
        for(int i = 0; i < SIZE*SIZE; ++i) {
            if (toggles[i]) {
                xorb(verify, check[i]);
            }
        }
        printGrid(verify);
        xorb(b2,verify);
        if (count(b2) > 0) {
            System.out.println("Aww, shuck, screwed up!");
            printGrid(b2);
        }
        printToggles(toggles);
    }
}