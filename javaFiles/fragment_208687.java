public static void main(String[] args) {
    ArrayList<Person> people = new ArrayList<Person>();

    people.add(new Employee("Tom", 4000, 1990, 3, 10));
    people.add(new Pupil("Dick", "Comp Sci"));
    people.add(new Employee("Harry", 4000, 1990, 3, 10));
    people.add(new Manager ("Dan", 5000, 1990, 10, 1));

    // manager arrayList does not exist
    //for (Manager m : manager)
    //{
    //  m.setBonus(5000);
    //}


    for (Person p : people){
        //Do this instead
        if (p instanceof Manager) {
            ((Manager) p).setBonus(5000);
        }

        System.out.println(p.getDetails());
    }
}