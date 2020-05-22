@Override
        public void actionPerformed(ActionEvent e) {
            try(Scanner sc = new Scanner(new File("Customers.txt"))) {
                while(sc.hasNextInt()) {
                    int cNumber = sc.nextInt();
                    if(cNumber == Integer.parseInt(userInput.getText()))
                        JOptionPane.showMessageDialog(null, "Customer Found" + cNumber);
                }
            }
            catch(IOException e1) {
                    JOptionPane.showMessageDialog(null,"Error");
            }