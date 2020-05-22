if (choice == 1) {
            cost = bagel;
            str = "Bagel";
            String inputStr = JOptionPane.showInputDialog(null,
                    "Enter quantity: 1-5");

        } else if (choice == 2) {
            cost = donut;
            str = "Donut";
            String inputStr = JOptionPane.showInputDialog(null,
                    "Enter quantity: 1-5");

        } else if (choice == 3) {
            cost = croissant;
            str = "Croissant";
            String inputStr = JOptionPane.showInputDialog(null,
                    "Enter quantity: 1-5");

        }
        float totCost = extracost + cost;
        JOptionPane.showMessageDialog(null,
                ("Breakfast ordered:" + str + "\nBeverage ordered: " + topstr
                        + "\nTotal cost: $" + totCost));