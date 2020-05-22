class Person implements Comparable {

    private String fName;
    private String lName;
    private Integer age;    
    public int compareTo(Object  obj) {
        Person o= (Person) obj;
        int thisCmp = age.compareTo(o.age);        
        return (thisCmp != 0 ? thisCmp : lName.compareTo(o.fName));
     }  
}