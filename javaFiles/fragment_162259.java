for (int h = 0; h < altura; h++) {

        System.out.printf("");
        for (int w = 0; w < largura - 1; w++) {
            System.out.print("*-");
        }

        System.out.println("*");
        if (h < altura - 1) { // add this condition to avoid printing the extra line
            for (int w2 = 0; w2 < largura - 2; w2++) {
                System.out.print("| ");
            }

            System.out.print("|");
            System.out.println(" |");
        }
    }