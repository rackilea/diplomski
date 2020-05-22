String[] strings = str.split(" ");
    ArrayList processed = new ArrayList();
    for (String token : strings) {
        if (token.endsWith("_hr")){ //rule 2
            processed.add(token.replace("_hr", ""));
        } else if (token.endsWith("_hi")) { //rule 1
            continue;
        } else { //any other case, rule 3
            processed.add(token); 
        }
    }