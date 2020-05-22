String [] arr = {"PR", "PS", "QS", "QT", "RP", "RT", "SP", "SQ", "TQ", "TR"};
    List<String> list = Arrays.asList(arr);

    for (int i = 0; i < list.size() - 1; i = i + 2) {
        System.out.printf("%s %s %n", list.get(i), list.get(i + 1));
    }