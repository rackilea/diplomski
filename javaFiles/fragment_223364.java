public class Triangle {
    public static void main(String[] args) {
        print(5, 3, 'w');
    }

    private static void print(int h, int H, char x) {
        //h for height of the triangle, H for the height of pattern and x the char.
        for(int n = 1; n <= H; n++) {
            printTriangle(n, h, x);
        }
    }

    private static void printTriangle(int numTriangles, int h, char x) {
        for(int i = 0; i < h; i++) {
            //Let's print the line in the triangles with spaces.
            for(int n = 0; n < numTriangles - 1; n++) {
                for(int j = 0; j <= i; j++) {
                    System.out.print(x);
                }
                for(int j = i+1; j < h; j++) {
                    System.out.print(" ");
                }
            }
            //The last one has no spaces so:
            for(int j = 0; j <= i; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}