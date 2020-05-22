public static void main(String[] args) throws IOException {

    int i, j;

    for (i = 1; i < 6; ++i) {
        for (j = 1; j < i + 1; ++j) {
            System.out.print(i);
        }
    }

    System.out.println();

    for (i = 1; i < 6; i++) {
        if (i % 2 == 1) {
            for (j = 1; j < i + 1; ++j){
            System.out.print("+");
            }
        } else {
            for (j = 1; j < i + 1; ++j){
                System.out.print("*");
            }
        }
    }

    System.out.println();

    for (i = 2; i < 8; i++) {
        if (i % 3 == 1) {
            for (j = 1; j <= i; ++j){
                System.out.print("+");
            }
        } else if (i % 3 == 2) {
            for (j = 1; j <= i; ++j){
                System.out.print("-");
            }
        } else {
            for (j = 1; j <= i; ++j){
                System.out.print("*");
            }
        }
    }
}