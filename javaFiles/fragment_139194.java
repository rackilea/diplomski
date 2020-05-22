public class Test {

    public static void main(String[] args) {
        int[] values = {4,100,2,20};
        System.out.println(randomValue(values));

        List<Integer> listOfValues = new ArrayList<Integer>(values.length);
        for (int value : values) {
            listOfValues.add(value);
        }
        Collections.shuffle(listOfValues);
        System.out.println(listOfValues.get(0));
    }

    public static  int randomValue(int... values) {
        int index = (int)Math.round(Math.random() * values.length);
        return values[index];
    }

}