for (index=0; index < iOne.length; index++) {

        String value = JOptionPane.showInputDialog("Input a data value:");
        double valIn = Double.parseDouble(value); // this line is changed
        iOne[index] = valIn;
    }