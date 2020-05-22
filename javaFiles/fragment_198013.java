import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test{
public static void main(String args[]){
    try{
        System.out.println(checkIfFileExists("test.png",""));
    }catch(Exception e){
        e.printStackTrace();
    }
}

public static String checkIfFileExists(String image_name,String from) throws IOException
    {
    String newimage = "test.png";
    String path="D:/";
    //Properties props_load = Utility.getProperties();
    path = "D:/";//props_load.getProperty("videopath"); 
    File file =  new File(path+image_name);
    if (!file.createNewFile())  // **if file name already exists**
    { 
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);
    Matcher matcher = Pattern.compile("(.*)\\.(.*?)").matcher(image_name);
    if (matcher.matches()) {  // <== test input filename is OK?
    newimage = String.format("%s_%d.%s", matcher.group(1), randomInt, matcher.group(2));
    }
    }
    else
    {
    newimage = image_name;
    }
    return newimage;
    }