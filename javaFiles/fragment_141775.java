public class ArrayOperations {
    public double getAverage(int[] array) {
        double total = 0; 
        double average; 
        for (int index = 0; index < array.length; index++)
            total += array[index];

        average = total / array.length;
        return average;
    }

    public int getHighest(int[] array) {
        String output = new String("");
        int highest = array[0];
        for(int i = 1; i < array.length; i++) {
            if (array[i] > highest)
                highest = array[i];
        }
        return highest; 
    }
}