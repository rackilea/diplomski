import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class CacheData {

    public static void main(String[] args) throws IOException {
        String target_dir = "C:\\Files";
        String output = "C:\\files\\output.txt";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();

        if (files == null || files.length < 1) {
            System.out.println("File list is empty...");
            return;
        }

        // open the Printwriter before your loop
        PrintWriter outputStream = new PrintWriter(output);
        //( //comparator if you want something else than natural ordering)
        Map<String, DataContent> myCachedTreeMap = new TreeMap<String, DataContent>();

        for (File textFile : files) {
            if (textFile.isFile() && textFile.getName().endsWith(".txt")) {
                BufferedReader inputStream = null;
                // close the outputstream after the loop
                outputStream.close();
                String content = "";
                try {
                    inputStream = new BufferedReader(new FileReader(textFile));
                    String line;
                    while ((line = inputStream.readLine()) != null) {
                        content += line;
                        System.out.println(line);
                        // Write Content
                        outputStream.println(line);
                    }
                    //create content
                    DataContent dataContent = new DataContent(System.currentTimeMillis(), textFile.lastModified(), content, textFile.getName());
                    //add to your map
                    myCachedTreeMap.put(textFile.getName(),dataContent );

                } finally {
                    if (inputStream != null) {
                        inputStream.close();

                    }
                }
            }
        }

        String fileNameYouWantFromCache = "myFile.txt";
        //how to use it.
        DataContent dataContent = myCachedTreeMap.get(fileNameYouWantFromCache);
        System.out.println(fileNameYouWantFromCache +" : \n"+ dataContent);
    }


    public static class DataContent {
        private long cachedTime; //currentTime
        private long lastModifiedTimestamp;
        private String contents;
        private String fileName; //not sure if you want it

        public DataContent(long cachedTime, long lastModifiedTimestamp, String contents, String fileName) {
            this.cachedTime = cachedTime;
            this.lastModifiedTimestamp = lastModifiedTimestamp;
            this.contents = contents;
            this.fileName = fileName;
        }

        public long getCachedTime() {
            return cachedTime;
        }

        public long getLastModifiedTimestamp() {
            return lastModifiedTimestamp;
        }

        public String getContents() {
            return contents;
        }

        public String getFileName() {
            return fileName;
        }

        @Override
        public String toString() {
            return "DataContent{" +
                    "fileName='" + fileName + '\'' +
                    ", contents='" + contents + '\'' +
                    ", lastModifiedTimestamp=" + lastModifiedTimestamp +
                    ", cachedTime=" + cachedTime +
                    '}';
        }
    }
}