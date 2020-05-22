//this is our class within the library. We cant edit its source
class APIClass {
    private int privatefield;

    public int getPrivatefield() {
        return privatefield;
    }
}

class MyExtendedAPIClass extends APIClass {
    // you dont have to override doStuff and doMoreStuff

    public void setPrivatefield(int value) {
        try {
            Field field = this.getClass().getSuperclass().getDeclaredField("privatefield");
            field.setAccessible(true);
            field.set(this, value);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}