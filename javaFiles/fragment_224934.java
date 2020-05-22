String aggFileName = "agg-"+String.valueOf("06.txt");
FileWriter fstream = new FileWriter(aggFileName);
BufferedWriter out = new BufferedWriter(fstream);

for (Map.Entry<String, String> entry : sortMap.entrySet()) {
     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); //this statement prints out my keys and values
     out.write(entry.getKey() + "\t" + entry.getValue());
     System.out.println("Done");
     out.flush();   // Flush the buffer and write all changes to the disk
 }

out.close();    // Close the file