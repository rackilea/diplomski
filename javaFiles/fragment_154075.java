public class Start {

public static void main(String[] args)
{
 //deleted some variables to make the code look cleaner
 auswahl = frame_main.auswahl;

}   


public static check(String auswahl) {
    //I want to call this while loop 
    while(run){
        System.out.println("Welche Zahl ist vorhanden? \nDual, Hexa, Oktal oder Dezimal?");

        if((auswahl).equals("Dual") || (auswahl).equals("dual"))
        {
            System.out.println("Dual wurde ausgewählt");
            System.out.println("Dezimal: " + dezimalzahlen.dualUmrechnung());
            System.out.println("Oktal: " + oktaldezimalzahlen.dualUmrechnung());
            System.out.println("Hexa: " + hexadezimalzahlen.dualUmrechnung());
            System.out.println("-------------------------");
        }
        else 
        {
            if((auswahl).equals("Hexa") || (auswahl).equals("hexa"))
            {
                System.out.println("Hexa wurde ausgewählt");
                System.out.println("Dezimal: " + dezimalzahlen.hexadezimalUmrechnung());
                System.out.println("Dual: " + dualzahlen.hexadezimalUmrechnung());
                System.out.println("Oktal: " + oktaldezimalzahlen.hexadezimalUmrechnung());
                System.out.println("-------------------------");
            }
            else
            {
                if((auswahl).equals("Oktal") || (auswahl).equals("oktal"))
                {
                    System.out.println("Oktal wurde ausgewählt");
                    System.out.println("Dual: " + dualzahlen.oktaldezimalUmrechnung());
                    System.out.println("Dezimal: " + dezimalzahlen.oktaldezimalUmrechnung());
                    System.out.println("Hexa: " + hexadezimalzahlen.oktaldezimalUmrechnung());
                    System.out.println("-------------------------");
                }
                else
                {
                    if((auswahl).equals("Dezimal") || (auswahl).equals("dezimal") )
                    {
                        System.out.println("Dezimal wurde ausgewählt");
                        System.out.println("Dual: " + dualzahlen.dezimalUmrechnung());
                        System.out.println("Oktal: " + oktaldezimalzahlen.dezimalUmrechnung());
                        System.out.println("Hexa: " + hexadezimalzahlen.dezimalUmrechnung());
                        System.out.println("-------------------------");
                    }
                    else
                    {
                        if((auswahl).equals("Exit") || (auswahl).equals("exit"))
                        {
                            System.out.println("Das Programm wurde beendet.");
                            run = false;
                        }
                        else
                        {
                            System.out.println("Keine Übereinstimmung, bitte erneut versuchen");
                        }
                    }
                }
            }
        }
    }
}

}