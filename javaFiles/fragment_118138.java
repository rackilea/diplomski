int columns = 5;
int lines = 3;

    int j = 0;
    do {
        for (int i = 0; i < columns - 1; i++) {
            System.out.print("   |");
        }

        System.out.printf("%n");

        if (j < lines - 1) {

            System.out.print("---");
            for (int i = 1; i < columns; i++) {
                System.out.print("+---");
            }
        }
        System.out.printf("%n");

        ++j;
    } while (j < lines);
}