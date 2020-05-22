public static void main(String[] args) {

        String pn = scan.nextLine();
        boolean valid = true;

        if (pn.length() == 13){
            for (int i = 0 ; i < 13 ; i++){
                switch(i){
                case 0 : valid = pn.charAt(0) == '(';break;
                case 4 : valid = pn.charAt(4) == ')';break;
                case 8 : valid = pn.charAt(8) == '-';break;
                default : valid = Character.getNumericValue(pn.charAt(i)) >= 0 &&  Character.getNumericValue(pn.charAt(i))<= 9 ; break;
                }
                if (!valid) break;
            }
            if (!valid) System.out.println("Invalid number");
        }else{
            valid = false;
            System.out.println("Invalid length");
        }

        if (valid){
            System.out.println(pn + " is a valid telephone number");
        }
    }