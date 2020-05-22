public static void main (String [] args){
        File file = new File("data.txt");

            Scanner scanner;
            try {
                scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);

                    line = line.substring(7, line.length()-1);
                    String name = line.substring(0, line.indexOf("\"")-1);

                    int index = line.indexOf("movie: \"");
                    line = line.substring(index+8, line.length()-1);
                    String movie = line.substring(0, line.indexOf("\"")-1);

                    System.out.println("name: \"" + name + "\", movie: \"" + movie + "\",");
                }
                scanner.close();

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


    }