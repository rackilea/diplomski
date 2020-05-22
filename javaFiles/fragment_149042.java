for(String line : list) {

   String[] lineSplitArray = line.split(":");
   studentNames[count] = lineSplitArray[0];
   studentIDs[count] = Integer.parseInt(lineSplitArray[1]);
   studentScores[count] = Double.parseDouble(lineSplitArray[2]);
   count++;
}