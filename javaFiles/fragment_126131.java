import java.io.FileWriter;
...
FileWriter writer = new FileWriter("output.txt"); 
for(String str: arr) {
  writer.write(str + System.lineSeparator());
}
writer.close();