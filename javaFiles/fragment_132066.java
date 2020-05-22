String input;
            String string = "";
            do {
                input = JOptionPane.showInputDialog("Enter String ");
                if (input.matches("^[a-zA-Z0-9]*$")) {
                    string = input;
                    System.out.println("Name "+string);
                } else {
                    System.out.println("Please enter a valid name containing: ‘a-z’ or ‘A-Z’ lower or upper case or numbers");
                }
            } while (!input.matches("^[a-zA-Z0-9]*$"));