try {
    Enum.valueOf(YourEnumType.class, "VALUE");
} catch(IllegalStateException e) {
    e.printStackTrace();
    //was not enum
}