public class BaseDomain<T>{


    public String getName() {
        return this.getClass().getField("name").get(this);
    }

    public void setName(String value) {
        this.getClass().getField("name").set(this, value);
    }

}