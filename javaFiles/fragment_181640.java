BufferedReader reader = null;
List<String> list = new ArrayList<>();
try {
    reader = new BufferedReader(new FileReader("input.txt"));
    String temp;
    while ((temp= reader.readLine()) != null) { 
        list.add(temp); 
    }
}
catch (FileNotFoundException e) { e.printStackTrace(); } 
catch (IOException e) { e.printStackTrace(); }
finally {
    try { if (reader != null) { reader.close(); } } 
    catch (IOException e) { e.printStackTrace(); }
}
System.out.println(String.format("%12s%12s%12s%12s%12s%12s\n\n", 
    "v_25", "v_72", "m_25", "m_75", "Sub", "Enroll"));
for(int i= 0;i < list.size();i++){
    String temp2[] = list.split(",");
    if(temp2.length == 6){
        System.out.println(String.format("%12s%12s%12s%12s%12s%12s\n\n", temp2[0], temp2[1],temp2[2],temp2[3],temp2[4],temp2[5]);
    }
    else{ 
        System.out.println("Error");
    }
}