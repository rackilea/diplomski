int finalNumber = 0;
    for (int j = 0; j < str.length(); j++){
      ch = str.charAt(j);
      if ((ch + 0) >= 48 && (ch + 0) <= 57){
        int digit = ((ch + 0) - 48);
        finalNumber = finalNumber*10 + digit;
        //System.out.println(digit);
      }
    }
    System.out.println(finalNumber);
    System.out.println();
    StringBuilder finalString = new StringBuilder();
    for (int k = 0; k < str.length(); k++){
      if (str.toLowerCase().charAt(k) >= 'a' && str.toLowerCase().charAt(k) <= 'z') {
        //System.out.println(str.charAt(k));
      finalString.append(str.charAt(k));
      }
    }
    System.out.println(finalString.toString());