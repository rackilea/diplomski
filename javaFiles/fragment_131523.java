List<List<String>> dList = new ArrayList<>();
    dList.add(Arrays.asList("A", "B", "C"));
    dList.add(Arrays.asList("f", "t", "j"));
    dList.add(Arrays.asList("g", "4", "h"));

    String a = dList.stream().flatMap(List::stream).filter(xx -> xx.equals("a")).findAny().orElse(null);
    a = dList.stream().flatMap(List::stream).filter(xx -> xx.equalsIgnoreCase("a")).findFirst().orElse(null);
    a = dList.stream().flatMap(List::stream).filter(xx -> xx.equals("h")).findFirst().orElse(null);