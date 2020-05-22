private static void quadList(ArrayList<String> list) {

    int listSize = list.size();

    for (int i = 0; i < listSize; i++) {

        for (int j = 0; j < 4; j++) {
            String temp = list.get(i);
            list.add(temp);

        }

    }