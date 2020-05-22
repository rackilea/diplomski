BufferedReader br = new BufferedReader(new FileReader(filename));
String line = null;
while ((line = br.readline()) != null) {
      Student st = new Student();
      String[] cols = line.split(";");
      int id = Integer.parseInt(cols[0]);
      st.setId(id);
      // .. so on for other indices like cols[1] etc..
}
br.close();