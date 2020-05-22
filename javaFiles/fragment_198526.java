import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
public class Format {


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd ',' MMM yyyy", Locale.ENGLISH);
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        String text = "John.Davidson/05051988/Belgrade Michael.Barton/01011968/Krakov Ivan.Perkinson/23051986/Moscow";
        String[] newText = text.split("[./ ]");
        for(int i=0; i<newText.length; i+=4)
        {
            String name = newText[i].split(" ")[0];
            String lastName = newText[i+1].split(" ")[0];
            String dateOfBirth = newText[i+2].split(" ")[0];
            String placeOfBirth = newText[i+3].split(" ")[0];


            System.out.println("Name: " + name + ", last name: " + lastName + ", date of birth: " + formatter.format(parser.parse(dateOfBirth)) + ", place of birth: " + placeOfBirth);
        }}


}