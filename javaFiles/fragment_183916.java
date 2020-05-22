public static interface Food {
    String name();
}
public enum Veggie implements Food {
    SALAD;
}
public static enum Meat implements Food {
    CHICKEN;
}

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public static class UseInterface {

    @XmlJavaTypeAdapter(FoodAdapter.class)
    @XmlAttribute
    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}

public static class FoodAdapter extends XmlAdapter<String, Food> {

    @Override
    public Food unmarshal(String v) throws Exception {
        try {
            return Veggie.valueOf(v);
        } catch (IllegalArgumentException e) {

        }
        try {
            return Meat.valueOf(v);
        } catch (IllegalArgumentException e) {

        }
        throw new IllegalArgumentException("Unknown Food:" + v);
    }

    @Override
    public String marshal(Food v) throws Exception {
        return v.name();
    }

}