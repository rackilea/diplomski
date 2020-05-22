import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='id')
class Employee {
    int id
    String name
}