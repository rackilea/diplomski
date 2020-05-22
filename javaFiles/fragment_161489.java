final File data = new File("D:\\Studies\\BCAS\\HND\\Semester 1\\Programming Concepts\\Assignment\\AccountPIN.tab");
Account userAcc = null;
for (Account acc : getAccounts(data)) {          
    if(userPIN.equals(acc.getPin())){
        userAcc = acc;
    }
}
if (userAcc == null) {
    obj1.MainMenu();
} else {
    // display error
}