public static String split_in_string(int [] an){
        int ans;
        String ansl = "";
        for(int i = 0; i < an.length; i++){
            ans = an[i];
            ansl = Integer.toString(ans); 
         // return ansl; //commented out this line
            Sysytem.out.println(ansl+" "); //added tjis line
        }
        return ansl;
    }