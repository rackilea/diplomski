public class Sensordevice {
    private List valueList;

    public <T> void setValueList(List<T> valueList) {
        this.valueList = valueList;
    }

    public <T> void addValue(T value) {
        if(valueList == null){
            valueList = getList(value.getClass());
        }
        valueList.add(value);
    }

    private <T> List<T> getList(Class<T> requiredType) {
        return new ArrayList<>();
    }
}

public static void main(String[] args) {
    Sensordevice sd = new Sensordevice();
    sd.addValue(new Object());
    sd.addValue(new Integer(3));
    sd.addValue("");
    sd.addValue(new Sensordevice());

    System.out.println(sd.getList(Sensordevice.class));
}