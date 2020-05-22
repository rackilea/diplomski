public void setHost(int i) {
    if(i < 0 || i > hosts.size()-1){
         throw new IllegalArgumentException("Index is out of range!");
    }
    headHost = hosts.get(i);
}

public void setHost(String name) {
    if(!hosts.contains(name){
         throw new IllegalArgumentException("The specified host does not exist.");
    }
    headHost = name;
}