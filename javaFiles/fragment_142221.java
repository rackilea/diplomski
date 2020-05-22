package toBeDeleted;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MarksProcessor {


    private final Map<String, Record> map = new HashMap<>();

    public static void main(String[] args) {
        String fileName = "file1.txt"; // change it to your specific file.
        MarksProcessor marksProcessor = new MarksProcessor();
        marksProcessor.processFile(fileName, 0);
        fileName = "file2.txt";
        marksProcessor.processFile(fileName, 1);
        marksProcessor.writeData();

    }

    private void processFile(String fileName, int marksIndex) {
        try(/*specify your reader resources here*/) {
            // read the first record and get rollNumber, name and marks.
            String roll = "valueYouGot";
            double value = 0.0; // the value you read.
            Record record = map.get(roll);
            // if record is null, you need to create one
            // and put it into the map.
            //record.updateMarks(marksndex, value);
        }
    }

    private void writeData() {

        // if this needs to be written to a file/stream, create a writer.
        for (Map.Entry<String, Record> entry : map.entrySet()) {
            String roll = entry.getKey();
            Record record = entry.getValue();
            if (record != null) {
                String name = record.getName();
                double marks1 = record.getMarks(0);
                double marks2 = record.getMarks(1);
                // Now you have all the values. Print them 
                // however you like. Wherever you like.
            }
        }
    }

    static class Record {
        private String name;
        private double[] marks = new double[2];


        Record(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getMarks(int index) {
            if (index < 0 || index > 1)
                throw new IllegalArgumentException("index should be 0 or 1 but"
                        + " the supplied index was " + index);
            return marks[index];
        }
        public void updateMarks(int index, double value ) {
            if (index < 0 || index > 1)
                throw new IllegalArgumentException("index should be 0 or 1 but"
                        + " the supplied index was " + index);
            marks[index] = value;
        }


        @Override
        public String toString() {
            return "the way you want to type your output";
        }

    }


}