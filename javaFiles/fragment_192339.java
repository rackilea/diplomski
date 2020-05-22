File file = new File(fileName);
 Scanner fileScan = new Scanner(file); // mistake passed fileName instead of file, changed from Scanner fileScan = new Scanner(fileName)

 while (fileScan.hasNextLine()) {
        fileScan.nextLine(); // changed from fileScan.next()
        counter++;
    }