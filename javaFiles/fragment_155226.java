Set<Double> set = new TreeSet();
br = new BufferedReader(new InputStreamReader(file, Charset.forName("UTF-8")));
while ((line = br.readLine()) != null) {
     if(line.contains("Error) {
      set.add(Double.valueOf(line.split("Error: ")[1]));
     }
}