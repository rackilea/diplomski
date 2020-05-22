Scanner input = new Scanner(System.in);
            String strMessage = input.nextLine();
            String strChars = " !@#$%^&&*()";
            String temp = "";
            boolean isInStrChars = false;

            for (int i = 0; i < strMessage.length(); i++){
                isInStrChars = false;
                for (int j = 0; j < strChars.length(); j++) {
                    if (strChars.charAt(j) == strMessage.charAt(i)) {
                        isInStrChars = true;
                    }
                }
                if(!isInStrChars){
                    temp+=strMessage.charAt(i);
                }
            }
            System.out.println(temp);