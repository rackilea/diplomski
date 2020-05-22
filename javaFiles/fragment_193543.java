for(int i=0;i<al.size();i++) {
    System.out.println("element enterd in for loop: "+al.get(i));    
    if(al.get(i).toString().charAt(0)>=65 & al.get(i).toString().charAt(0)<=122) {
        al.remove(i);
        i--; // make sure you are not skipping the element following the removed element
        continue;
    }
}