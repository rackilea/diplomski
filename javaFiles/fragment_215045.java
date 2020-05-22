class Person implements Comparable{
    String name;
    String gender;
    int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(Object arg0) {
        Person p = (Person)arg0;
        return p.getAge() - this.getAge();
    }


}