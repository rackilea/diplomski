public enum DaysILike {
    FRIDAY, SATURDAY, SUNDAY
}

public enum DaysIDontLike {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY
}

public static void main(String[] args) {
    List<Class<?>> enums = new ArrayList<>();
    enums.add(DaysIDontLike.class);
    enums.add(DaysILike.class);
    String yourString = "THURSDAY";
    Enum<?> en = getEnumFromMany(enums, yourString);
    System.out.println(en + " from " + en.getClass());
}