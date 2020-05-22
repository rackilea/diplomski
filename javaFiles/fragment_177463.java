else if (valid_len == true){
       for (i = 0; i < len; i++){
              passwd_l = in_pass.charAt(i);
              if (Character.isLetter(passwd_l))
              {
                    l ++;
              }
              if (Character.isDigit(passwd_l))
              {
                    d ++;
              }
       }
} 
if (l > 0 && d > 0){
       System.out.println("Password Accepted");
}