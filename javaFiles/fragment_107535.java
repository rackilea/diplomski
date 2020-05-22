String pass = "password" 
if( !pass.equals(pass.toLowerCase()) ) //fails

String pass = "passWord";
//lower casing becomes "password" and as a result, "passWord" doesn't match "password"
if( !pass.equals(pass.toLowerCase()) ) //passes