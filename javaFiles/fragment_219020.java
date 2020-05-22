String data[] = { 
        "alksjdasdlfj", 
        "alsjdf ajsdfl",
        "lkj-asdfj alsdjflj", 
        "lksaldf asldjf-jasfd-alsdjf",
        "asjdfkl-ajsdf-asdjf-alsdjf", 
        "lasdjf--asdjfj", };
for (String s : data)
    System.out.println(s+ " : " + 
            s.matches("(?i)[a-z]+(-[a-z]+){0,2}( [a-z]+(-[a-z]+){0,2})*"));