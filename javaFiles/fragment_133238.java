public static void main(String[] args){
    AClonable one = new ClonebaleOne("One");
    AClonable tow= new ClonebaleTwo("Two");
    AClonable clone = one.clone();
    System.out.println(clone.toString());
    clone = tow.clone();
    System.out.println(clone.toString());

}