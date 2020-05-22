public void splitStr(){
        String str = "";
        String[] split_str = str.split(",");

        int len = split_str.length;

        int split_len = len/3;

        for (int i = 0; i< len; i++){
            String f1 ="";
            if(i == split_len){
                // first string 
                f1 = split_str[i];

                // You will get 3   f1 strings
                split_len += split_len+ i;
            }
        }
    }