public static Double[] fileRead(String filename) {
  List<Double> list= new ArrayList<Double>();
  BufferedReader br = new BufferedReader(new FileReader(fileName));
  try {
        String line = br.readLine();
        while (line != null) {
            list.add(Double.parseDouble(line));
            line = br.readLine();
        } 
        return list.toArray(new double[list.size()]);
    } catch(Exception e){
         return null;
    }finally {
         br.close();
    }
}