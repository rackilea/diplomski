String filename = "E:\\csv.csv";
BufferedReader fileReader = null;

//Delimiter used in CSV file
final String DELIMITER = ",";

String line = "";
//Create the file reader
fileReader = new BufferedReader(new FileReader(filename ));

//Read the file line by line
while ((line = fileReader.readLine()) != null)
{
    //Get all tokens available in line
    String[] tokens = line.split(DELIMITER);
    for(String token : tokens)
    {
        //Print all tokens
        System.out.println(token);
    }
}