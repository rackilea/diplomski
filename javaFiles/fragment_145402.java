ArrayList<Points2D> p = new ArrayList<>();

Scanner numFile = new Scanner(new File("myValues.txt"));

String pointOnLine = numFile.readLine();

while (numFile != null) //if line exists
{

     String[] pointToAdd = pointOnLine.split(" +"); //get x y coords from each line, using a white space delimiter
     //create point2D object, then add it to the list  
     Point2D pointFromFile = new Point2D(Integer.parseInt(pointToAdd[0]), Integer.parseInt(pointToAdd[1]));
     p.add(pointFromFile);
     numFile = numFile.readLine();  //assign numFile to the next line to be read

}