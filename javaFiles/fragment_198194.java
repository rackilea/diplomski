public static void main(String[] args) {



    Person p1 = new Person("Fred", 24);
    Person p2 = new Person("Sally", 26);
    Person p3 = new Person("Billy", 55);

    Person[] people = {p1,p2,p3};

    for(Person p : people){
        System.out.println(p.toString());
    }
}