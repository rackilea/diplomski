input.useDelimiter("\n");//take input per line
while(input.hasNext() && !found){
    String userDetails=input.next().trim();
    String credentialInfo[]=userDetails.split(",");
    if(!userDetails.isEmpty() 
            && credentialInfo.length==2) {//validate your input
        tempUsername = credentialInfo[0];
        tempPassword = credentialInfo[1];
        if (tempUsername.trim().equals(username.trim()) 
                && tempPassword.trim().equals(password.trim())){
              //rest of your code...