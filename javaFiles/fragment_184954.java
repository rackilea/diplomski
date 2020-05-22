String[][] data = getFromCSV("StaffHoursOverviewReport_10102019 (1).txt",
                             "outFile.txt", 
                             13, 16, 17, 28, 29);
for (int i = 0; i < data.length; i++) {
    String dataString = data[i][0].replace("\"", "") + ", " + 
                        data[i][1] + " " + data[i][2] + " , " + 
                        data[i][3].replace(".", " ") + data[i][4];
    System.out.println(dataString);
}