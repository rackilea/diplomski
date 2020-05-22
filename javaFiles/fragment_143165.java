import java.io.*;
import java.util.*;
import java.util.logging.*;

/** JDK before version 7. */
public class ExerciseSerializable {

  public static void main(String... aArguments) {
    //create a Serializable List
    List<String> quarks = Arrays.asList(
      "up", "down", "strange", "charm", "top", "bottom"
    );

    //serialize the List
    //note the use of abstract base class references

    try{
      //use buffering
      OutputStream file = new FileOutputStream("quarks.ser");
      OutputStream buffer = new BufferedOutputStream(file);
      ObjectOutput output = new ObjectOutputStream(buffer);
      try{
        output.writeObject(quarks);
      }
      finally{
        output.close();
      }
    }  
    catch(IOException ex){
      fLogger.log(Level.SEVERE, "Cannot perform output.", ex);
    }

    //deserialize the quarks.ser file
    //note the use of abstract base class references

    try{
      //use buffering
      InputStream file = new FileInputStream("quarks.ser");
      InputStream buffer = new BufferedInputStream(file);
      ObjectInput input = new ObjectInputStream (buffer);
      try{
        //deserialize the List
        List<String> recoveredQuarks = (List<String>)input.readObject();
        //display its data
        for(String quark: recoveredQuarks){
          System.out.println("Recovered Quark: " + quark);
        }
      }
      finally{
        input.close();
      }
    }
    catch(ClassNotFoundException ex){
      fLogger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
    }
    catch(IOException ex){
      fLogger.log(Level.SEVERE, "Cannot perform input.", ex);
    }
  }

  // PRIVATE 

  //Use Java's logging facilities to record exceptions.
  //The behavior of the logger can be configured through a
  //text file, or programmatically through the logging API.
  private static final Logger fLogger =
    Logger.getLogger(ExerciseSerializable.class.getPackage().getName())
  ;
}