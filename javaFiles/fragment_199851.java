public class PersonService {
    protected int lastItemInPersonArray = 0;
    private Person[] persons = new Person[100];
    public void addPersonToPersonArray(Person personToAdd) {
        persons[lastItemInPersonArray++] = personToAdd;
    }   
    public static void main(String[] args) {
        PersonService ps = new PersonService();
        ps.addPersonToPersonArray(new Person("P 1"));
        ps.addPersonToPersonArray(new Person("P 2"));
        ps.addPersonToPersonArray(new Person("P 3"));   
        System.out.println(ps.persons[0].nome);
        System.out.println(ps.persons[1].nome);
        System.out.println(ps.persons[2].nome);
    }
}
class Person{
    public Person(String nome) {
        this.nome = nome;
    }
    String nome;
}