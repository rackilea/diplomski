List<User> l=(List<User>) sess.getAttribute("allUserslist");
for(int ii=0;ii<l.size();){
    System.out.println("bef"+l.get(ii).getLoginName()+optionSelected[i]);
    if(l.get(ii).getLoginName().equals(optionSelected[i])){
        System.out.println("in iteration");
        l.remove(ii)); // Remove user from the list
    } else {
        ++ii;
    }
}

List<User> l1=(List<User>) sess.getAttribute("allUserslist");
System.out.println("final size"+l1.size());