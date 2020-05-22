public static void main(String[] args) throws Exception {
    final String DATE_FORMAT_REGEX = "(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2}):(\\d{2}).*";
    final Pattern DATE_FORMAT_PATTERN = Pattern.compile(DATE_FORMAT_REGEX);
    final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
    String file1 = "C:\\templog\\myLog1.log";
    String file2 = "C:\\templog\\myLog2.log";
    PrintWriter writer = new PrintWriter("C:\\templog\\expectedLog.txt", "UTF-8");
    // 1) Get the file list
    List<String> fileFile = Arrays.asList(file1, file2);
    ArrayList<BufferedReader> readerIndex = new ArrayList<BufferedReader>();
    ArrayList<String> lineList = new ArrayList<String>();
    ArrayList<Date> dateList = new ArrayList<Date>();
    for (String file : fileFile) {
        // 2) Create BufferedReader list with respect to the file.
        BufferedReader br1 = new BufferedReader(new FileReader(file));
        readerIndex.add(br1);
        // 3) Read the 1st line of each line and store it in another list.
        String line = br1.readLine();
        lineList.add(line);
        // 4) Store the date from the 1st line of each file.
        String date = line.substring(0, 23);
        Date convertedDate = sdf.parse(date);
        dateList.add(convertedDate);
    }
    int index = readerIndex.size();
    // 5) While BufferedReader's size is not zero then,
    while (index > 0) {
        // 6) Take the index of minimum date from dateList
        int indexMin = minDateIndex(dateList);
        // 7) Get the Line with the index you got in the previous step (lineToWrite).
        String lineToWrite = lineList.get(indexMin);
        writer.println(lineToWrite);
        // 8) Get the buffered reader with the index.
        BufferedReader br1 = readerIndex.get(indexMin);
        if (br1 != null) {
            //  9) If the BR is not null then read the line.
            String line = br1.readLine();
            if (line != null) {
                // 10)If line is not equal to null then remove the lineList from the index and add the line to index.
                lineList.remove(indexMin);
                lineList.add(indexMin, line);
                if (line.length() > 23) {
                    // 11)If the line length is greater than 23 (yyyy-MM-dd HH:mm:ss,SSS) then take the first 23 String from the line.
                    String date = line.substring(0, 23);
                    Matcher matcher = DATE_FORMAT_PATTERN.matcher(date);
                    if (matcher.matches()) {
                        // 12)Check if the date matches to the pattern, if matches then add the date to dateList
                        Date convertedDate = sdf.parse(date);
                        dateList.remove(indexMin);
                        dateList.add(indexMin, convertedDate);
                    }
                }
            } else {
                //If line is null then remove the min indexed line from lineList,dateList,BufferedReader list. Do BufferedReader--.
                lineList.remove(indexMin);
                dateList.remove(indexMin);
                readerIndex.remove(indexMin);
                br1.close();
                index--;
            }
        }
    }
    writer.close();
}

private static int minDateIndex(ArrayList<Date> dateList) {
    // return index of min date
    Date minDate = dateList.get(0);
    int minIndex = 0;
    for (int i = 1; i < dateList.size(); i++) {
        Date currentDate = dateList.get(i);
        if (minDate != null) {
            if (currentDate != null) {
                if (minDate.after(currentDate)) {
                    // We have a new min
                    minDate = dateList.get(i);
                    minIndex = i;
                } else {
                    // we keep current min
                }
            } else {
                // we keep current min
            }
        } else {
            minDate = currentDate;
            minIndex = i;
        }
    }
    return minIndex;
}