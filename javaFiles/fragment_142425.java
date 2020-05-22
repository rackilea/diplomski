import java.util.ArrayList;

    public class NewMain {
        public static void main(String[] args) {
            ArrayList<String> array = new ArrayList<>();
            array.add("Ace of Hearts");
            array.add("King of Clubs");
            array.add("Three of Spade");
            array.add("Ace of Hearts");
            array.add("Ten of Clubs");
            for(int i =0;i<array.size();i++)
                System.out.println(array.get(i)+"at postion: "+i);
        }
    }