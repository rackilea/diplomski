@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public static class UseInterface {

    @XmlElement
    private Object food;

    public Food getFood() {
        return (Food) food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        if (food != null && !(food instanceof Food)) {
            throw new IllegalArgumentException("food is of wrong type: " + food.getClass().getName());
        }
    }
}

JAXBContext newInstance = JAXBContext.newInstance(UseInterface.class, Meat.class, Veggie.class);
String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><useInterface><food xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"meat\">CHICKEN</food></useInterface>";

newInstance.createUnmarshaller().unmarshal(new StringReader(xml));