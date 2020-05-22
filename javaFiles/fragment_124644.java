String s = "Bananas22Apples496Pears3";

String[] res = s.replaceAll("(?<=\\p{L})(?=\\d)", ":").split("(?<=\\d)(?=\\p{L})");
    for (String t : res) {
        System.out.println(t);
    }