boolean youShallNotPass = true;
while(read.hasNext()){
    String user = read.next();
    String pass = read.next();
    read.next();

    if(inputUser.equals(user) && inputPass.equals(pass)){    
        youShallNotPass = false;
        break;
    }
}

if(!youShallNotPass){    
    JOptionPane.showMessageDialog(this, "Login Sucessful");
} else {
    JOptionPane.showMessageDialog(null,"Incorrect Username and Password");
}