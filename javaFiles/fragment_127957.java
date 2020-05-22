public int getX(String object) {
    try {
        return Plasmaburst2.Body.class.getDeclaredField(object + "X");
    } catch(NoSuchFieldException | SecurityException e) {
        return 0;
    }
}