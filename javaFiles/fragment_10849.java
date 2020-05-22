FileInputStream fis = new FileInputStream(fin);

//Construct BufferedReader from InputStreamReader
BufferedReader br = new BufferedReader(new InputStreamReader(fis));

String line = null;
while ((line = br.readLine()) != null) {
      int vertex = Integer.parseInt(line.substring(0, line.indexOf(":")) //get the number before : 
       String neighboorString = (line.substring(line.indexOf("[")+1, line.indexOf("]") //get the string between [ ]
      List<Integer> neighbors = new ArrayList<Integer>();
      for (String neighbor : neighborString.split(",")) { //split the string between , to get the neighbor id
            neighbors.add(Integer.parseInt(neighbor))

       }
       //populate your structure as required)
}
//close the streams/readers