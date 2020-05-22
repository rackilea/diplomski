List<Integer> listNumber = new ArrayList<>();
    List<String> listOperation = new ArrayList<>();

    for (String s : list) {
        if (testInteger(s)) {
            listNumber.add(Integer.parseInt(s));
        } else {
            listOperation.add(s);
        }
    }
    System.out.println(listNumber);
    System.out.println(listOperation);
}