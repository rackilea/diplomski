f = new File("myFile.txt");
fw = new FileWriter(f);
fw.write("This is a sentence that should appear in the file.");
fw.flush();
fw.close(); // actually free any underlying file handles.
if(f.delete())
    System.out.println("File was successfully deleted.");
else
    System.err.println("File was not deleted.");