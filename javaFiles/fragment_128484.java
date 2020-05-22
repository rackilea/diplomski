for (int i = 0; i < dividedByNewLine.length; i++) {
        if(!dividedByNewLine[i].trim().equals("")) {
            String[] divideByComma = dividedByNewLine[i].split(",");

        list = new ArrayList<String>();
        for (int j = 0; j < divideByComma.length; j++) {
            list.add(divideByComma[j].trim());
        }
        if (!list.isEmpty()) {
            map.put(i, list);
        }
        System.out.println(map.get(i));
        }
}