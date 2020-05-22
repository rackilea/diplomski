if (someCondition) {
    stmt = connection.prepareStatement("stuff");
    stmt.set... // set attributes
} else if (anotherCondition) {
    stmt = connection.prepareStatement("some stuff");
    // set attributes
} else {
    stmt = connection.prepareStatement("even more stuff");
    //set attributes
}