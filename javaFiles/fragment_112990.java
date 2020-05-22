public void FileMoving()   
{  
   //created object for Class   
   ExternalFileExecutions ExternalFileExecutionsObject=new ExternalFileExecutions();  
   //calling Method from class object
   List<String> fileNames = ExternalFileExecutionsObject.ListOfFileNames("C:/Documents and Settings/mahesh/Desktop/InputFiles",".txt");    
   //to find out the length of list
   System.out.println(fileNames.size());  
}
public List<String> ListOfFileNames(String directoryPath,String fileType)
{
    //Creating Object for File class
    File fileObject=new File(directoryPath);
    //Fetching all the FileNames under given Path
    File[] listOfFiles=fileObject.listFiles();
    //Creating another Array for saving fileNames, which are satisfying as far our requirments
    List<String> fileNames = new ArrayList<String>();
    for (int fileIndex = 0; fileIndex < listOfFiles.length; fileIndex++) 
    {
        if (listOfFiles[fileIndex].isFile())
        {
          //True condition,Array Index value is File
          if (listOfFiles[fileIndex].getName().endsWith(fileType)) 
          {
              //System.out.println(listOfFiles[fileIndex].getName());
              fileNames .add(listOfFiles[fileIndex].getName());
          }
       }
     }  
     return fileNames ;

  }