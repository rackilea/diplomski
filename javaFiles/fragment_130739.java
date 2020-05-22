static class DeceasedPerson {
    String name;
    LocalDate birthDate;
    LocalDate deathDate;

    DeceasedPerson(String name, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    @Override
    public String toString() {
        return name + ", " + birthDate + ", " + deathDate;
    }
}