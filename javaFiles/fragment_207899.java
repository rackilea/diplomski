List<String> finalList = new ArrayList<String>();
    for (String letter: list1) {
        for (String number: list2) {
            finalList.add(letter + number);
        }
    }

    System.out.println(finalList);