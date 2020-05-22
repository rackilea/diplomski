String newString = "4a2b";
    String num = "";
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < newString.length(); i++) {
        char ch = newString.charAt(i);

        if (Character.isDigit(ch)) {
            num += ch;

        } else if (Character.isLetter(ch)) {
            if (num.length() > 0) {
                for (int j = 0; j < Integer.parseInt(num); j++) {
                    res.append(ch);
                }
            }
            num="";
        }
    }
    System.out.println(res);