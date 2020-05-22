class Person {
   public static int compareByAge(Person a, Person b) {
       return a.birthday.compareTo(b.birthday);
   }}
}

Arrays.sort(persons, Person::compareByAge);