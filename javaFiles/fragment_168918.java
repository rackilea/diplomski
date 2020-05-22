import java.util.Calendar;
import java.util.Random;

public class Agent
{

    String gender;
    String birthday;

    public static Agent GetRandomAgent()
    {
        Agent randomAgent = new Agent();

        WordList maleName = new WordList("MaleNames.txt");
        WordList femaleName = new WordList("FemaleNames.txt");
        WordList cityBorn = new WordList("Cities.txt");
        WordList cityNow = new WordList("Cities.txt");
        WordList major = new WordList("Majors.txt");

        //Setter methods
        //Sets the gender of the agent generated 
        double setGender = (Math.random());

        Random r = new Random();

        if(Math.random() * 100 > 50)
        {
            randomAgent.gender = "female";
        }
        else //if not female, then male
        {
            randomAgent.gender = "male";
        }
        randomAgent.birthday = randomAgent.setBirthday();
    }

    public String setBirthday()
    {
        int birthdayYear = 1900 + (int) (Math.random() * ((2012 - 1900) + 1));
        int birthdayMonth = 1 + (int) (Math.random() * ((12 - 1) + 1));
        int birthdayDay;
        switch(birthdayMonth)
        {
            //set for 30-day months: April(4), June(6), September(9), November(11)
            case 4:
            case 6:
            case 9:
            case 11:
                birthdayDay = 1 + (int) (Math.random() * ((30 - 1) + 1));
                break;

            case 2:
                if(isLeapYear(birthdayYear))
                {
                    birthdayDay = 1 + (int) (Math.random() * ((29 - 1) + 1));
                }
                else
                {
                    birthdayDay = 1 + (int) (Math.random() * ((28 - 1) + 1));
                }
                break;

            //Set for 31-day months: January(1), March(3), May(5), July(7), August(8), October(10), December(12)
            default:
                birthdayDay = 1 + (int) (Math.random() * ((31 - 1) + 1));
                break;
        }

        //Convert the random integers back into Strings (easier to use)
        String year = Integer.toString(birthdayYear);
        String month = Integer.toString(birthdayMonth);
        String day = Integer.toString(birthdayDay);

        //Account to make sure there is a zero before the date (clarity)
        if(birthdayMonth < 10)
        {
            month = "0" + birthdayMonth;
        }

        if(birthdayDay < 10)
        {
            day = "0" + birthdayDay;
        }

        String suffix;
        if((day.equals("01") || (day.equals("21") || (day.equals("31")))))
        {
            suffix = "st";
        }

        if((day.equals("02") || (day.equals("22"))))
        {
            suffix = "nd";
        }

        if(day.equals("03") || day.equals("23"))
        {
            suffix = "rd";
        }
        else
        {
            suffix = "th";
        }
        return this.birthday = (day + suffix + " " + month + " of " + year);
    }

    public static boolean isLeapYear(int year)
    {
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.YEAR, year);
        int numberOfDays = rightNow.getActualMaximum(Calendar.DAY_OF_YEAR);

        if(numberOfDays > 365)
        {
            return true;
        }
        return false;
    }
}