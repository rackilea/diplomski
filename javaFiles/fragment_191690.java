public abstract class BaseItem implements Item {
    String name;
    boolean valid = true;

    public void postCalucate() {
        //common calculation
        valid = valid && (name != null);
    }

    public boolean isValid() { 
        return valid; 
    }

    public String getName() {
        return name;
    }
}