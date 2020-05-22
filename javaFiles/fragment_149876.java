char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p','r','s','t','u', 'v', 'z'};

        String message = " This is message for coding";

        message = message.toLowerCase();
        char[] messageArray = message.toCharArray();

        for(int i = 0; i < message.length(); i++)
        {
            for(int j =0; j < alphabet.length; j++)
            {
                if(message.charAt(i) == alphabet[j]){
                    messageArray[i] = alphabet[(j + 3)%alphabet.length];
                }
            }
        }
        System.out.println(String.copyValueOf(messageArray));