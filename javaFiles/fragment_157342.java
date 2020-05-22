import java.util.ArrayList;

public class CS1702_Lab5 {
    public static void main(String args[]) {
        ArrayList<Data> data = new ArrayList<Data>();
        data.add(new Data("Fred", 21));
        PrintDataArray(data);  // YOU NEED TO ADD THIS LINE.
    }

    private static void PrintDataArray(ArrayList<Data> data) {
        for (int i = 0; i < data.size(); ++i) {
            data.get(i).Print();
        }
    }


}