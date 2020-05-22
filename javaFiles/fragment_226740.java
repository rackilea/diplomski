public int compareTo(Object obj) {
    if(obj == null)
            return 1;
    else if (obj instanceof Person)
    {
        Person p2 = (Person) obj;
        if(this.gender.compareTo(p2.gender) < 0)
            return 1;
        else if(this.gender.compareTo(p2.gender) == 0)
            return this.age.compareTo(p2.age);
        else
            return -1;
    }
    else return 1;

}