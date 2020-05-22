import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TitanicApp {

    int size = 10;
    int colCount = 6;
    String[][] array = null;

    public static void main(String[] args) {
        TitanicApp app = new TitanicApp();
        app.startExec();
    }

    public void startExec() {

        array = new String[size][colCount];
        String fileLine;
        int i=0;

        try 
        {
            BufferedReader inputStream = new BufferedReader(new FileReader("C:/titanic.txt"));
            while ((fileLine = inputStream.readLine()) != null) {
                addTo2DArray(fileLine.split("\\t"), ++i);
            }
            inputStream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        // Now you have the desired array : array;
    }

    public void addTo2DArray(String[] tmpArray, int minCapacity) {
        if((minCapacity > size)) {
            size = (size * 3)/2 + 1;
            String[][] newArray = new String[size][colCount];
            for(int i=0; i<array.length; i++) {
                for(int j=0; j<array[i].length; j++) {
                    newArray[i][j]=array[i][j];
                }
            }
            array = newArray;
        }
        array[minCapacity-1] = tmpArray;
    }
}