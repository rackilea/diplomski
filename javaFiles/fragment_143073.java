Person person1 = new Person("Foo", 100);
Person person2 = new Person("Foo", 100);
// This is fine. Two distinct Person objects will never be equal...
if (person1.equals(person2)) {
    launchNuclearMissiles();
}