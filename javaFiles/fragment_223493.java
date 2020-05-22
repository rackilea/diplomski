import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class fileio
{
    public static void main(String args[])
    {
        fileio mainObject=new fileio();

        book javabook=new book();
        javabook.name="Java unleashed";
        javabook.author="someone";
        javabook.nop=1032;
        javabook.price=450;
        javabook.discount=10;
        javabook.getDiscount();
        mainObject.writeToFile(javabook);
    }
        public void writeToFile(book javabook)
        {
        try
        {
        File file=new File("JavaBook1.txt");
        FileWriter fw=new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(javabook.toString());
        bw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}