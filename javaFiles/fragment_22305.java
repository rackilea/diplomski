class Dim
{
    // dimensions
    static int d1 = 2 ;   // "rows"
    static int d2 = 2;    // "cols"
    static int d3 = 3;    // "height"
    static int d4 = 2;    // the fourth dimension!

    public static void main(String[] args) {
        for (int i=0; i<d1; i++) {
            for (int j=0; j<d2; j++) {
                for (int k=0; k<d3; k++) {
                    for (int m=0; m<d4; m++) {
                        int oneD = fourDtoOneD(i, j, k, m);
                        System.out.printf("(%d, %d, %d, %d) -> %d\n", i, j, k, m, oneD);
                    }
                }
            }
        }
    }

    static int fourDtoOneD(int i, int j, int k, int m) {
        return ((d2*d3*d4) * i) + ((d2*d3) * j) + (d2 * k) + m;
    }
}


$ java Dim
(0, 0, 0, 0) -> 0
(0, 0, 0, 1) -> 1
(0, 0, 1, 0) -> 2
(0, 0, 1, 1) -> 3
(0, 0, 2, 0) -> 4
(0, 0, 2, 1) -> 5
(0, 1, 0, 0) -> 6
(0, 1, 0, 1) -> 7
(0, 1, 1, 0) -> 8
(0, 1, 1, 1) -> 9
(0, 1, 2, 0) -> 10
(0, 1, 2, 1) -> 11
(1, 0, 0, 0) -> 12
(1, 0, 0, 1) -> 13
(1, 0, 1, 0) -> 14
(1, 0, 1, 1) -> 15
(1, 0, 2, 0) -> 16
(1, 0, 2, 1) -> 17
(1, 1, 0, 0) -> 18
(1, 1, 0, 1) -> 19
(1, 1, 1, 0) -> 20
(1, 1, 1, 1) -> 21
(1, 1, 2, 0) -> 22
(1, 1, 2, 1) -> 23