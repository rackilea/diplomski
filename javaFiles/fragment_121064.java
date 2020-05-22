public class Main {

    public static void main(String[] args) {

        String [] a = {"aaa"};
        List<String[]> values = new LinkedList<>();

        values.add(a);


        List<String[]> copy = new ArrayList<>();
        for(String[] stringArray : values) {
            String[] newArray = Arrays.copyOf(stringArray, stringArray.length);
            copy.add(newArray);
        }


        values.get(0)[0] = "bbb";

        System.out.println(values.get(0)[0]);
        System.out.println(copy.get(0)[0]);
    }
}