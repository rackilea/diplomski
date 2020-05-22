String line = scannerA.nextLine();
String[] parsed = line.split("\\s"); //split at whitespace
String otherFileName = parsed[0];    //other filename was 1st part of line

File dir = //what directory are the files in?
File otherFile = new File(dir, otherFileName);
//now read this file the same way as you read the previous one