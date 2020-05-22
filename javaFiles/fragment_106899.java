allPersons.stream()
    .filter(this::female)
    .filter(this::hasChildrenUnder10)
    .collect(toList())

//...

private boolean female(Person p) { return p.getGender() == Female; }
private boolean hasChildrenUnder10(Person parent) {
    return parent.getChildren().stream()
                    .anyMatch(c -> c.getAge() < 10));
}