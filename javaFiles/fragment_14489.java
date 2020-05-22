Grid<Person> grid = new Grid<>();
grid.setDataProvider(...);

ValueProvider<Person, String> cssClassProvider = (person) -> {
    String cssClass = "my-grid-cell";
    if (person.getAge() <= 16) {
        cssClass += " junior";
    } else if (person.getAge() >= 60) {
        cssClass += " senior";
    }
    return cssClass;
};

grid.addColumn(TemplateRenderer.<Person>
        of("<div class$=\"[[item.class]]\">[[item.age]]</div>")
            .withProperty("class", cssClassProvider)
            .withProperty("age", Person::getAge));
grid.addColumn(TemplateRenderer.<Person>
        of("<div class$=\"[[item.class]]\">[[item.name]]</div>")
            .withProperty("class", cssClassProvider)
            .withProperty("name", Person::getName));