public enum Sex {

    MALE('M'), FEMALE('F'), UNKNOWN('U');

    char name;

    Sex(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public static Sex getByName(char name) {
        return Arrays.stream(Sex.values())
                .filter(sex -> sex.getName() == name)
                .findFirst()
                .orElse(UNKNOWN);
    }
}