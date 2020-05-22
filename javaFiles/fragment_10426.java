public Friend getFriend(String phone) {
if(friends.size() != 0){
    for(Friend f : friends) {
        if(f.getPhone().equals(phone)){
            return f;
        }
    }
}
return null;       
}