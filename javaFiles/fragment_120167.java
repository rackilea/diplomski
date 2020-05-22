int newData = 0;
        boolean haveInt = true;
        try {
                 newData = Integer.parseInt(theInputString);
        } catch (NumberFormatException e) {
            haveInt = false;
        }
        if (haveInt) {
           intArrayList.add(newData);
        }