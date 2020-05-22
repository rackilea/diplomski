for (char count = 'A'; count <= 'Z'; count++) {
            System.out.print(count + ": " +
                    letterCount [count - 'A'] + " ");
            if (count == 'M') {
                System.out.println();
            }

        }