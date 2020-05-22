String input = "U80 G9 Q4";
    ArrayList<Integer> ints = new ArrayList<Integer>();
    ArrayList<Character> chars = new ArrayList<Character>();
    for (int i = 0; i < input.length() - 1; i++) {
        char letter = input.charAt(i);
        String num = "";
        for(int j=i+1;j<input.length();j++){
            i++;
            if(input.charAt(j)!=' '){
                num+=input.charAt(j);
            }else{
                break;
            }
        }
        int number = Integer.parseInt(num + "");
        ints.add(number);
        chars.add(letter);
    }
    for (int i = 0; i < ints.size(); i++) {
        System.out.println("Letter: " + chars.get(i) + " Number: " + ints.get(i));
    }