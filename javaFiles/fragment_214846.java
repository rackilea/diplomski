public static Person findById (Person[] people, int id) {
    for (Person p : people) {
        if (p.getId() == id) {
            return p;
        }
    }
    return null;
}