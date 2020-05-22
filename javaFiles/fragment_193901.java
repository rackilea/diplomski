Scanner in = new Scanner(csvFile);
while (in.hasNextLine()) {
    String[] fields = in.nextLine().split(",");
    if (fields.length == 5) {
        nameList.add(fields[0]);
        popList.add(fields[1]);
        areaList.add(fields[2]);
        gdpList.add(fields[3]);
        litRateList.add(fields[4]);
    } else {
        // Bad line...do what you want to show error here
    }
}