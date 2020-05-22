public static boolean isNullOrEmpty(String... strArr) {
       for (String st : strArr) {
            if  (st==null || st.equals(""))
               return true;

       } 
       return false;
}



boolean result = isNullOrEmpty(string1,strin2,string3,string4,string5);