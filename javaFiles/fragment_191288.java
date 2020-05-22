int current = n%m;
    StringBuilder sb = new StringBuilder();
    List<Integer> controlSet = new ArrayList<>();
    while((!controlSet.contains(current))){
        int currentDigit = current *10 / m;
        sb.append(currentDigit);
        controlSet.add(current);
        current = current *10 - m * currentDigit;
    }
    String fraction = sb.toString().substring(0, controlSet.indexOf(current));
    String repeat = sb.toString().substring(controlSet.indexOf(current));