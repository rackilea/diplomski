public enum Gender {

    Male(1), Female(0);

    private int id;

    private Gender(int id) { 
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Gender valueOf(int id) {
        for (Gender gender : values()) {
            if (gender.id == id) {
                return gender;
            }
        }

        return null;
    }

}