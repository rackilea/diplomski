public FileReader fr = new FileReader("path/to/your/file");
public BufferedReader br = new BufferedReader(fr);
String unique;
String line;
while((line =  br.readLine()) != null){
    if (line.contains("UniqueID"))
    {
        unique = line.split(":")[1].trim();
        break;
    }
}