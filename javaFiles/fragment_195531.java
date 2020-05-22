public  void removeSpaces(String str){
        String ourString="";
        for (int i=0; i<str.length()-1 ; i++){
            if(i==0){
                ourString = ""+str.charAt(i);
            }else{
                if(str.charAt(i-1) != str.charAt(i)){
                    ourString = ourString +str.charAt(i);
                }
            }           
        }
        System.out.println(ourString);
    }