String dateString, currentTimeStamp;
SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss_SSS");
Date returnTime = new Date();

dateString = formatter.format(returnTime);
currentTimeStamp = formatter.format(new Date());

BufferedWriter fw = new BufferedWriter(new FileWriter("E:\\log.txt"));
fw.newLine();
fw.write("," + "server timestamp   " + "," + " Timestamp");
fw.newLine();
fw.write(" ,");
fw.write(dateString + "," + currentTimeStamp);
fw.flush();
fw.close();