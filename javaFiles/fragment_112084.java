String[] data = new String[]{"[A] ::= [A]B | C | [D]", "[D] ::= C[D] | C"};
    List<String> nonter = new ArrayList<>();
    List<String> ter = new ArrayList<>();

    for (String aData : data) {
        String Data[] = aData.split("::=");
        nonter.add(Data[0]);
        ter.add(Data[1]);
    }

    String replaced = ter.get(0).replaceAll("\\[\\w]|\\s|\\|", "");

    for (char ch : replaced.toCharArray()) {
        System.out.println(ch);
    }