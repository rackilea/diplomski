class Person implements Comparable<Person> {

    private String fName;
    private String lName;
    private Integer age;

    public int compareTo(Person o) {
        int thisCmp = age.compareTo(o.age);        
        return (thisCmp != 0 ? thisCmp : lName.compareTo(o.fName));
     }      
}