private static String getGreater(String Version1, String Version2){
        //Splitting numbers to String array based on .
        String[] v1 = Version1.split("\\.");
        String[] v2 = Version2.split("\\.");

        //Start with any one of the splitted array
        for(int i = 0;i < v1.length;i++){
            int a1 = Integer.parseInt(v1[i]);
            int a2 = Integer.parseInt(v2[i]);
            //Start from left to right, Convert to int and then check for which is greater. When you find greater return specified version
            if(a1 > a2){
                return Version1;
            }else if(a1 < a2){
                return Version2;
            }
        }
        //If you reach here either one of the version is null/blank  or both are same so return anythign. You might need to check at your end
        //that you don't send null or blanks to this method/
        return Version1;
    }