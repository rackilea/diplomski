import java.util.Scanner;

public class StackOverflow_32900399 {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        try
        {
            System.out.println("Enter a year");
            int year = input.nextInt();

            System.out.println("Enter first weekday of year e.g.: 0 for Sunday");
            int weekDay = input.nextInt();

            for (int month = 1; month <= 12; month++)
            {
                printMonthHeader(month, year);
                weekDay = printDaysOfMonth(month, year, weekDay);
                System.out.println("\n");
            }
        }
        finally
        {
            input.close();
        }
    }

    private static void printMonthHeader(int monthOfYear, int year)
    {       
        String month = "";

        switch (monthOfYear)
        {
            case 1 : month = "January"; break; 
            case 2 : month = "February"; break; 
            case 3 : month = "March"; break; 
            case 4 : month = "April"; break; 
            case 5 : month = "May"; break; 
            case 6 : month = "June"; break; 
            case 7 : month = "July"; break; 
            case 8 : month = "August"; break; 
            case 9 : month = "September"; break; 
            case 10 : month = "October"; break; 
            case 11 : month = "November"; break; 
            case 12 : month = "December"; break; 
        }


        System.out.println(month + " " + year);
        System.out.println("___________________________________");
        System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat ");
    }

    private static int printDaysOfMonth(int monthOfYear, int year, int startOn)
    {
        int daysInMonth = 0;
        int currentDay = startOn;

        switch(monthOfYear)
        {
            case 4 : 
            case 6 : 
            case 9 : 
            case 11 : 
                daysInMonth = 30;
                break;
            case 2:
                daysInMonth = ((year % 4) == 0 ? 29 : 28);
                break;
            default: 
                daysInMonth = 31;
        }

        StringBuilder buff = new StringBuilder();
        if (currentDay != 0)
        {
            buff.append(String.format("%1$"+(5*startOn)+ "s", ""));
        }

        for (int day = 1; day <= daysInMonth; day ++)
        {
            String padding = day > 9 ? "  " : "   ";
            buff.append(padding + day + " ");

            if (currentDay == 6)
            {
                buff.append("\n");
                currentDay = 0;
            }
            else
            {
                currentDay++;
            }
        }

        System.out.println(buff.toString());
        System.out.println("___________________________________");
        return currentDay;
    }

}