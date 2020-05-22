Student toUpdate = db4o.query(new Predicate<Student>() {
    @Override
    public boolean match(Student student) {
        return pilot.rollNo.equals("44");
    }
}).get(0);

toUpdate.name ="newName";

db4o.store(toUpdate); // Updated