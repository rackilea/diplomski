int day = 0;
    while (day < 30) {

        try {
            int high = Integer.parseInt(JOptionPane.showInputDialog("please enter the high"));
            H[day] = high;
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
        }

        try {

            int low = Integer.parseInt(JOptionPane.showInputDialog(" Please enter the low"));
            L[day] = low;

        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
        }

        day++;
    }