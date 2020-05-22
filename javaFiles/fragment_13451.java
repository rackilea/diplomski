String s = "10.2";
    try {
        int i = Integer.parseInt(s);
        //int routine
        System.out.println(i);
    } catch (NumberFormatException e) {
        if (s.matches("-?\\d+(\\.\\d+)?")) {
            double d = Double.parseDouble(s);
            //double routine
            System.out.println(d);
        } else {
            // "Wrong value on the input area.Please use number." + "\n" + "Check                       //diameter input.", "Error message!",
            System.out.println("Wrong");
            throw new IllegalArgumentException();
        }
    }