public class JavaApplication255 {

    public static void main(String[] args) {
        // write your code here
        List<String> list = new ArrayList<>();
        list.add("hi");
        list.add("what");
        list.add("who");
        list.add("ok");

        removeTwos(list);
        System.out.println(list);
    }

    public static void removeTwos(List<String> stringList){

        for(int i = stringList.size() - 1; i >= 0 ; i--){
            String string = stringList.get(i);

            if (string.length() == 2){
                stringList.remove(string);
            }
        }
    } 
}