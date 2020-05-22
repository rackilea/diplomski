int count = -1;
...
while ((line = br.readLine()) != null) {
    if(line.contains("{")){
        count++;
        for(int i = 0; i < count; i++)
             line = line.replaceAll("\\{", "\t\\{");
    } else if(line.contains("}")) {
        for(int i = 0; i < count; i++)
             line = line.replaceAll("\\}","\t\\}");
        count--;
    }                                       
    pw.println(line);
    System.out.println(line);
}