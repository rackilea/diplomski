public Object getValueAt(int row, int col) {

    Person person = personList.get(row);
    switch (col) {
    case 0:
        return person.getName();
    case 1:
        return person.getBorndate();
    case 2:
        return person.getSalary();
    case 3:
        return person.getAge();
    case 4:
        return person.getCity();
    default:
        break;
    }
}