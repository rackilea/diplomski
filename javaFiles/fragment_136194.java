while (fileScan.hasNextLine()) {
        String[] temp = fileScan.nextLine().split(" ");
        if (temp.length == 2){
            houseList.add(new Household(Short.parseShort(temp[0]),
            Integer.parseInt(temp[1])));
        }
    }