public String getFirstWords(String original){
       String firstWord= "";
       String[] split = original.split(" ");

       for(String value : split){
            firstWord+= value.substring(0,1);
        }

        return firstWord;
    }