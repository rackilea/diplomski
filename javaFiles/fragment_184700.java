public class Version implements Comparable<Version> {

    private final List<Integer> values;

    public Version(List<Integer> values) {
        this.values = values;
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public String toString() {

        return String.join("_", values
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList()));
    }

    @Override
    public int compareTo(Version that) {

        List<Integer> thatValues = that.getValues();

        for(int index = 0; index < values.size(); index++){

            Integer value = values.get(index);
            Integer thatValue = thatValues.get(index);

            if (value > thatValue) {
                return -1;
            } else if (value < thatValue) {
                return 1;
            }
        }

        return 0;
    }


    public static Version create(String value){

        String[] splitRes = value.split("_");
        List<Integer> intValues = new ArrayList<>();

        for(String v : splitRes){
            intValues.add(Integer.parseInt(v));
        }

        return new Version(intValues);
    }
}