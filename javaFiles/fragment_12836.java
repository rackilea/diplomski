MyField getMyField() {
    if (Hibernate.isInitialized(myField)) {
        return myField;
    }
    return null;
}