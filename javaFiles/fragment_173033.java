public static void main(String[] args){

    Cat c = new Cat();
    Submarine s = new Submarine();
    Dog d = new Dog();

    List<Enemy> v = new Vector<>(); //Vector that holds random Enemy objects

    v.add(c);
    v.add(s);
    v.add(d);

    System.out.println(v.get(0).getAction()); //should print "Meow!"
    System.out.println(v.get(1).getAction()); //should print 10 from the submarine object
    System.out.ptintln(v.get(2).getAction()); //should print "Bark!"
}