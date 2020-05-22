String line = "", oldtext = "";
while ((line = reader.readLine()) != null) 
{

   oldtext = oldtext + line + System.lineSeparator();
}
reader.close();

if(oldtext.contains(":20:")) {
    String replacedtext = oldtext.replaceAll("100", "200");

    FileWriter writer = new FileWriter(file);
    writer.write(replacedtext);

    writer.close();

    System.out.println("Done");
}