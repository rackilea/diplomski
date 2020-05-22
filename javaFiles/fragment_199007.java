public class Filereader {
    public static void main(String[] args) throws Exception {

    File file = new File("file.txt");
    File file2 = new File("file2.txt");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    BufferedReader reader2 = new BufferedReader(new FileReader(file2));
    String st, st2;

    Map<Integer, String> nameMap = new LinkedHashMap<>();
    Map<Integer, String> majorMap = new LinkedHashMap<>();

    while ((st = reader.readLine()) != null) { 
         System.out.println(st);
         String[] parts = st.split(" "); // Here you got ["James", "1"]
         String name = parts[0];
         Integer id = Integer.parseInt(parts[1]);
         nameMap.put(id, name);
    }
    while ((st2 = reader2.readLine()) != null) {
         System.out.println(st2);
         String[] parts = st2.split(" ");
         String name = parts[1];
         Integer id = Integer.parseInt(parts[0]);
         majorMap.put(id, name);
    }
    reader.close();
    reader2.close();

    // Combine and print
    nameMap.keySet().stream().forEach(id -> {
      System.out.println(nameMap.get(id) + " " + majorMap.get(id));
    })

    }
}