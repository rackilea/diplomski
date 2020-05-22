int i = 0;
int originalSize = userList.size(); // to prevent from iterating on elements 
                                    // added during the loop
while(i < originalSize){  
    userPrograms it= userList.get(i);  
    if ((it.userID == subsuserID) && (it.program == subsProgram)) {
        it.program += 1;
    } else {
        userPrograms p1 = new userPrograms(subsuserID, subsProgram, 0);
        userList.add(p1);
    }
    i++;
}