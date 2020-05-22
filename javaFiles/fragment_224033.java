boolean isPass = false;
while(rs.next()){
    // Your user authentication 
    if ((user.equals(uname)) && (pwd.equals(pass)))
    { 
        if (admin1.equals("y")) {
            // do your admin operation
            break;
        } else {   
            // do your non admin operation
            break;
        }
    } else {
        // if authentication fails 
        isPass = true
    }
}
// Outside of while block
if(isPass){
    // if authentication fails show error message
    JOptionPane.showMessageDialog(null,  "User name and password do"
           + " not match!","ALERT!", JOptionPane.ERROR_MESSAGE); 
}