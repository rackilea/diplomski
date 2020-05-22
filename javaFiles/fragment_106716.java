while (input.hasNext()) {
   // Read each line from the scanner
   String input = input.next();

   // Split data on two delimiters '-' and ':'
   String[] data = input.split("-|:");
   int listNumber = Integer.parseInt(data[0]);
   String listData1 = data[1];
   String listData2 = data[2];

   // Add to the datalist
   datalist.add(new ListData(listNumber, listData1, listData2));
}