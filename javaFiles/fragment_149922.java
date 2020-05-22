for (int a = 0; a < first.length; a++) {
                // catch the next
                for (int b = 0; b < first[a].length; b++) {
                    first[a][b] = inFile.nextInt();
                    System.out.print(first[a][b] + " ");
                    if (first[a][b] != 0) {
                        rind++;
                    }
                }
                System.out.println(" ");
            }