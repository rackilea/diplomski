String s = "# hello 1234";

    String[] tokens = {"# hello", "# bye"};

//s = s.substring(s.indexOf(String.valueOf(tokens)) + tokens.length);

    for (String token : tokens) {
        String[] split;
        if(s.contains(token)) {
            split = s.split(token);
            s = split[1].trim();
        }
    }

    System.out.print(s);