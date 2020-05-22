class StrategyOne implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().length() - p2.getName().length();
    }

}

class StrategyTwo implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }

}