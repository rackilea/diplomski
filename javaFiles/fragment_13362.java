package javaapplication18;

import java.text.NumberFormat;
import java.util.Locale;

public class JavaApplication18 {

    public static void main(String[] args) {

        String name = "Khalid";
        int age = 24;
        double gpa = 3.40;

        Locale arLocale = new Locale("ar");
        NumberFormat nf = NumberFormat.getInstance(arLocale);
        System.out.println("Country: " + arLocale.getCountry() + ", Language: " + arLocale.getLanguage());
        System.out.printf("%s is %s years old. %s has %s gpa. \n",
                name, nf.format(age), name, nf.format(gpa));

        Locale usLocale = new Locale("us", "EN");
        nf = NumberFormat.getInstance(usLocale);
        System.out.println("Country: " + usLocale.getCountry() + ", Language: " + usLocale.getLanguage());        
        System.out.printf("%s is %s years old. %s has %s gpa. \n",
                name, nf.format(age), name, nf.format(gpa));
    }
}