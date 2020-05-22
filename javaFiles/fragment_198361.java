int maxRows = 0;
            int maxColumn = 0;
            try {
                Scanner scanF = new Scanner(inputFile);
                String line = scanF.nextLine();
                while (line != null) {
                    if (line.trim().length() > 0) {
                        maxRows++;
                        String valVar[] = line.split(" ");
                        if (maxColumn < valVar.length) {
                            maxColumn = valVar.length;
                        }
                    }
                    try {
                        line = scanF.nextLine();
                    } catch (NoSuchElementException e) {
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }