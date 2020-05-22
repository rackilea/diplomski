try {
            File file = new File("newfile.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
              String input1 = input.readLine();// read one line
              String num[] = input1.split("\\|");// split line by "|"
                Book k1 = new Book(num[0], num[1]);

                listofbooks.add(k1);
            }
        } catch (FileNotFoundException e) {
            System.err.format("File does not exist");
        }