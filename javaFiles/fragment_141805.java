public static int contain(String s1, String s2){ 

    //local variable
    int variable = 0;

    if(s1.length() >= s2.length()){

        for(int i = 0; i < s1.length(); i++){
            variable = i;
            char s = s1.charAt(i);
            String s3 = "s3+s";
            if(s3.equals(s2)){
              //some code here
            } 
        }    
    }else
        System.out.println("-1"); 


    //Return the local variable
    return variable;
}