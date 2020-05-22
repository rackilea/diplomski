import java.util.*;
Scanner fileInput;
ArrayList<Double>ipt1 = new ArrayList<Double>();
File inFile = new File("input1.dat");

try {
    fileInput = new Scanner(inFile);
    //Reads file contents
while (fileInput.hasNext()){
    ipt1.add(fileInput.nextDouble()); //Adds the next Double to the ArrayList
    System.out.print(ipt1.get(ipt1.size()-1)); //Prints out what you just got.
}
fileInput.close();

}   
catch (FileNotFoundException e){
    System.out.println(e);
}

//Sorting time
//This uses the built-in Array sorting.
Collections.sort(ipt1);