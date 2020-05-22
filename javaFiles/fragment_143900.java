Array<String> arrayList = new ArrayList<>();
try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

    while ((String line = bufferedReader.readLine()) != null) {    
        line = line.replace("þ", "t");
        arrayList.add(line);
    }
} catch (Exception e) {
    e.printStackTrace();
}

try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
   for (String string : arrayList) {
      bw.write(string + "\n");
   }
} catch (Exception e) {
   System.err.println(e);
}