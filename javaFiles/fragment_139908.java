import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Text1 {
    public static final String filename = "SampleLottoData.txt";

    public static void main(String[] args) throws IOException, ParseException,
            AssertionError {
        File Numbers = new File(filename);
        Scanner in = new Scanner(Numbers);
        if (Numbers.exists()) {
            // ArgumentCheck(args);
            if (args.length <= 5) {
                int choice = Integer.parseInt(args[0]);
                if (args.length >= 2 && args.length <= 5) {
                    String drawtype = args[1].toUpperCase();

                    if (args.length >= 3 && args.length <= 5) {
                        int day = Integer.parseInt(args[2]);

                        if (args.length == 4) {
                            int year = Integer.parseInt(args[3]);

                            if (args.length == 1) {
                                JackpotOrBonus(args, in, choice);
                            } else if (args.length == 2) {
                                TypeOfDraw(args, in, choice, drawtype);
                            } else if (args.length == 3) {
                                DrawOnADay(args, in, choice, drawtype, day);
                            } else if (args.length == 4) {
                                DrawsForAYear(args, in, choice, drawtype, day,
                                        year);
                            } else if (args.length == 5) {
                                BetweenTwoDates(args, in, choice, drawtype, day);
                            }
                        }
                    }
                }
            }
        } else
            JOptionPane.showMessageDialog(null, "The file " + filename
                    + " doesn't exist");
    }

    public static void JackpotOrBonus(String[] args, Scanner in, int choice)
            throws IOException {
        int[] jackpotnumbers = new int[45];
        int[] bonusnumbers = new int[45];
        int[] jackpot = new int[6];
        int bonus = 0;
        String data = "";
        String[] temp = new String[9];
        if (choice == 1) {
            while (in.hasNext()) {
                data = in.nextLine();
                temp = data.split(",");
                for (int counter = 0; counter < jackpot.length; counter++) {
                    jackpot[counter] = Integer.parseInt(temp[counter + 1]);
                    jackpotnumbers[jackpot[counter] - 1]++;
                }
            }
            in.close();
        } else {
            while (in.hasNext()) {
                data = in.nextLine();
                temp = data.split(",");
                bonus = Integer.parseInt(temp[7]);
                bonusnumbers[bonus - 1]++;
            }
            in.close();
        }
        Printing(args, jackpotnumbers, bonusnumbers, bonus);
    }

    public static void TypeOfDraw(String[] args, Scanner in, int choice,
            String drawtype) throws IOException {
        int[] jackpotnumbers = new int[45];
        int[] bonusnumbers = new int[45];
        int[] jackpot = new int[6];
        int bonus = 0;
        String data = "";
        String[] temp = new String[9];
        if (choice == 1 || choice == 2) {
            while (in.hasNext()) {
                data = in.nextLine();
                temp = data.split(",");
                if (temp[8].contentEquals(drawtype)
                        || drawtype.contentEquals("A"))
                    for (int count = 0; count < jackpot.length; count++) {
                        jackpot[count] = Integer.parseInt(temp[count + 1]);
                        jackpotnumbers[jackpot[count] - 1]++;
                    }
            }
            in.close();
        }
        if (choice == 2) {
            while (in.hasNext()) {
                data = in.nextLine();
                temp = data.split(",");
                bonus = Integer.parseInt(temp[7]);
                if (temp[8].contentEquals(drawtype)
                        || drawtype.contentEquals("A"))
                    bonusnumbers[bonus - 1]++;
            }
            in.close();
        }
        Printing(args, jackpotnumbers, bonusnumbers, bonus);
    }

    public static void DrawOnADay(String[] args, Scanner in, int choice,
            String drawtype, int day) throws IOException {
        int[] jackpotnumbers = new int[45];
        int[] bonusnumbers = new int[45];
        int[] jackpot = new int[6];
        int bonus = 0;
        String data = "";
        int weekday;
        String[] temp = new String[9];
        if (choice == 1 || choice == 2) {
            while (in.hasNext()) {
                data = in.nextLine();
                temp = data.split(",");
                weekday = convertDateToWeekDay(temp);
                if (weekday == day || day == 0)
                    ;
                {
                    if (temp[8].contentEquals(drawtype)
                            || drawtype.contentEquals("A"))
                        for (int count = 0; count < jackpot.length; count++) {
                            jackpot[count] = Integer.parseInt(temp[count + 1]);
                            jackpotnumbers[jackpot[count] - 1]++;
                        }
                }
                in.close();
            }
            if (choice == 2) {
                while (in.hasNext()) {
                    data = in.nextLine();
                    temp = data.split(",");
                    weekday = convertDateToWeekDay(temp);
                    if (weekday == day || day == 0)
                        ;
                    {
                        bonus = Integer.parseInt(temp[7]);
                        if (temp[8].contentEquals(drawtype)
                                || drawtype.contentEquals("A"))
                            bonusnumbers[bonus - 1]++;
                    }
                }
                in.close();
            }
        }
        Printing(args, jackpotnumbers, bonusnumbers, bonus);
    }

    public static void DrawsForAYear(String[] args, Scanner in, int choice,
            String drawtype, int day, int year) throws IOException,
            ParseException {
        int[] jackpotnumbers = new int[45];
        int[] bonusnumbers = new int[45];
        int[] jackpot = new int[6];
        int bonus = 0;
        String data = "";
        int weekday;
        String[] temp = new String[9];
        String temporary = temp[0];
        String[] temps = temporary.split("/");
        int years = Integer.parseInt(temps[2]);
        weekday = convertDateToWeekDay(temp);
        while (in.hasNext()) {
            data = in.nextLine();
            temp = data.split(",");
            temporary = temp[0];
            temps = temporary.split("/");
            years = Integer.parseInt(temps[2]);
            weekday = convertDateToWeekDay(temp);
            if ((year == years)
                    && (temp[8].contentEquals(drawtype) || drawtype
                            .contentEquals("A"))
                    && (weekday == day || day == 0)) {
                if (choice == 1 || choice == 2) {
                    for (int count = 0; count < jackpot.length; count++) {
                        jackpot[count] = Integer.parseInt(temp[count + 1]);
                        jackpotnumbers[jackpot[count] - 1]++;
                    }
                }
                if (choice == 2) {
                    bonus = Integer.parseInt(temp[7]);
                    if (temp[8].contentEquals(drawtype)
                            || drawtype.contentEquals("A"))
                        bonusnumbers[bonus - 1]++;
                }
            }
        }
        in.close();
        EvenOrOdd(args, choice, in, years);
        Printing(args, jackpotnumbers, bonusnumbers, year);
    }

    public static void EvenOrOdd(String[] args, int choice, Scanner in, int year)
            throws ParseException {
        int length, number, odd = 0, even = 0, lowexceedshighr = 0, lowexceedshighs = 0, lowexceedshighlp1 = 0, lowexceedshighlp2 = 0;
        String data = "", weekday;
        String[] temp = new String[9];
        int[] jackpot = new int[6];
        if (choice == 1)
            length = 6;
        else
            length = 7;
        while (in.hasNext()) {
            int oddcounter = 0, evencounter = 0;
            data = in.nextLine();
            temp = data.split(",");
            String temporary = temp[0];
            String[] temps = temporary.split("/");
            for (int counter = 0; counter < length; counter++) {
                number = Integer.parseInt(temp[counter + 1]);
                if (number % 2 == 0)
                    evencounter++;
                else
                    oddcounter++;
            }
            if (evencounter == length)
                even++;
            else if (oddcounter == length)
                odd++;
            int years = Integer.parseInt(temps[2]);
            if (year == years) {
                int high = 36;
                String s39 = "22/08/1992";
                String s42 = "24/09/1994";
                String s45 = "4/11/2006";
                String datayear = temp[0];
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date datas = df.parse(datayear);
                Date ss39 = df.parse(s39);
                Date ss42 = df.parse(s42);
                Date ss45 = df.parse(s45);
                if (datas.equals(ss39)
                        || (datas.after(ss39) && datas.before(ss42)))
                    high = 39;
                else if (datas.equals(ss42)
                        || (datas.after(ss42) && datas.before(ss45)))
                    high = 42;
                else if (datas.equals(ss45) || (datas.after(ss45)))
                    high = 45;
                int limit = (high - 10);
                for (int count = 0; count < jackpot.length; count++)
                    jackpot[count] = Integer.parseInt(temp[count + 1]);
                int lowwinning = 0, highwinning = 0;
                for (int counter = 0; counter < jackpot.length; counter++) {
                    if (jackpot[counter] <= 10)
                        lowwinning++;
                    else if (jackpot[counter] >= limit)
                        highwinning++;
                }
                if (lowwinning > highwinning) {
                    if (temp[8].contentEquals("R"))
                        lowexceedshighr++;
                    else if (temp[8].contentEquals("S"))
                        lowexceedshighs++;
                    else if (temp[8].contentEquals("LP1"))
                        lowexceedshighlp1++;
                    else if (temp[8].contentEquals("LP2"))
                        lowexceedshighlp2++;
                }
            }
            in.close();
            String results = "";
            if (choice == 1) {
                results = "All Jackpot numbers were even " + even + " times.\n";
                results += "All Jackpot numbers were odd " + odd + " times.\n";
            } else {
                results = "All Jackpot and Bonus numbers were even " + even
                        + " times.\n";
                results += "All Jackpot and Bonus numbers were odd " + odd
                        + " times.\n";
            }
            results += "In " + args[3]
                    + " low winning numbers exceeded high winning numbers\n";
            results += lowexceedshighr + " in regular draws.\n";
            results += lowexceedshighs + " in special draws.\n";
            results += lowexceedshighlp1 + " in Lotto Plus 1 draws.\n";
            results += lowexceedshighlp2 + "in Lotto Plus 2 draws.";
            JOptionPane.showMessageDialog(null, results, "", 1);
        }

    }

    public static void BetweenTwoDates(String[] args, Scanner in, int choice,
            String drawtype, int day) throws IOException, ParseException,
            AssertionError {
        int[] jackpotnumbers = new int[45];
        int[] bonusnumbers = new int[45];
        int[] jackpot = new int[6];
        int bonus = 0;
        String data = "";
        int weekday = 0;
        String[] temp = new String[9];
        while (in.hasNext()) {
            data = in.nextLine();
            temp = data.split(",");
            String firstyear = args[3];
            String secondyear = args[4];
            String datayear = temp[0];
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date first = df.parse(firstyear);
            Date second = df.parse(secondyear);
            Date datas = df.parse(datayear);
            weekday = convertDateToWeekDay(temp);
            if (weekday == day || day == 0)
                ;
            {
                if (temp[8].contentEquals(drawtype)
                        || drawtype.contentEquals("A")) {
                    if ((datas.equals(first)) || (datas.equals(second))
                            || ((datas.after(first)) && (datas.before(second)))) {
                        if (choice == 1 || choice == 2) {
                            for (int count = 0; count < jackpot.length; count++) {
                                jackpot[count] = Integer
                                        .parseInt(temp[count + 1]);
                                jackpotnumbers[jackpot[count] - 1]++;
                            }
                        }
                        if (choice == 2) {
                            bonus = Integer.parseInt(temp[7]);
                            if (temp[8].contentEquals(drawtype)
                                    || drawtype.contentEquals("A"))
                                bonusnumbers[bonus - 1]++;
                        }
                    }
                }
            }
        }
        in.close();
        Printing(args, jackpotnumbers, bonusnumbers, weekday);
    }

    public static int convertDateToWeekDay(String[] temp) {
        int result = 0;
        int a, b, d, m, y, dayOfWeek;
        String date = temp[0];
        String[] dates = date.split("/");
        d = Integer.parseInt(dates[0]);
        m = Integer.parseInt(dates[1]);
        y = Integer.parseInt(dates[2]);
        if (m == 1 || m == 2) {
            m += 12;
            y -= 1;
        }
        a = y % 100;
        b = y / 100;
        dayOfWeek = ((d + (((m + 1) * 26) / 10) + a + (a / 4) + (b / 4)) + (5 * b)) % 7;
        switch (dayOfWeek) {
        case 0:
            result = 2;
            break;
        case 4:
            result = 1;
            break;
        }
        return result;
    }

    public static void Printing(String[] args, int[] jackpotnumbers,
            int[] bonusnumbers, int choice) {
        String results = "";
        if (args.length == 1) {
            if (choice == 1) {
                results = "An Analysis of Jackpot Numbers for the entire file.\n\n";
                for (int counter = 0; counter < 45; counter++) {
                    int num = counter + 1;
                    results += num + " was a jackpot number "
                            + jackpotnumbers[counter] + "times.\n";
                }
            } else {
                results = "An Analsis of Bonus Numbers for the entire file.\n\n";
                for (int counter = 0; counter < 45; counter++) {
                    int num = counter + 1;
                    results += num + " was a bonus number "
                            + bonusnumbers[counter] + "times.\n";
                }
            }
        }
        if (args.length == 2) {
            if (choice == 1) {
                if ((args[1].toUpperCase()).contentEquals("A"))
                    results = "An Analysis of Jackpot Numbers for the entire file.\n\n";
                else if ((args[1].toUpperCase()).contentEquals("R"))
                    results = "An Analysis of Jackpot Numbers for all regular draws.\n\n";
                else if ((args[1].toUpperCase()).contentEquals("S"))
                    results = "An Analysis of Jackpot Numbers for all special draws.\n\n";
                else if ((args[1].toUpperCase()).contentEquals("LP1"))
                    results = "An Analysis of Jackpot Numbers for all Lotto Plus 1 draws.\n\n";
                else
                    results = "An Analysis of Jackpot Numbers for all Lotto Plus 2 draws.\n\n";
                for (int counter = 0; counter < 45; counter++) {
                    int num = counter + 1;
                    results += num + " was a jackpot number "
                            + jackpotnumbers[counter] + "times.\n";
                }
            } else {
                if ((args[1].toUpperCase()).contentEquals("A"))
                    results = "An Analsis of Jackpot and Bonus Numbers for the entire file.\n\n";
                else if ((args[1].toUpperCase()).contentEquals("R"))
                    results = "An Analysis of Jackpot and Bonus Numbers for all regular draws.\n\n";
                else if ((args[1].toUpperCase()).contentEquals("S"))
                    results = "An Analysis of Jackpot and Bonus Numbers for all special draws.\n\n";
                else if ((args[1].toUpperCase()).contentEquals("LP1"))
                    results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 1 draws.\n\n";
                else
                    results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 2 draws.\n\n";
                for (int counter = 0; counter < 45; counter++) {
                    int num = counter + 1;
                    results += num + " was a bonus number "
                            + bonusnumbers[counter]
                            + "times and a jackpot number "
                            + jackpotnumbers[counter] + "times.\n";
                }
                if (args.length == 3) {
                    int numb = Integer.parseInt(args[2]);
                    if (choice == 1) {
                        if ((args[1].toUpperCase()).contentEquals("A"))
                            results = "An Analysis of Jackpot Numbers for the entire file";
                        else if ((args[1].toUpperCase()).contentEquals("R"))
                            results = "An Analysis of Jackpot Numbers for all regular draws";
                        else if ((args[1].toUpperCase()).contentEquals("S"))
                            results = "An Analysis of Jackpot Numbers for all special draws";
                        else if ((args[1].toUpperCase()).contentEquals("LP1"))
                            results = "An Analysis of Jackpot Numbers for all Lotto Plus 1 draws";
                        else
                            results = "An Analysis of Jackpot Numbers for all Lotto Plus 2 draws";
                        if (numb == 2)
                            results += "on Wednesday draws.\n\n";
                        else if (numb == 1)
                            results += " on Saturday draws.\n\n";
                        else
                            results += " for all draws.\n\n";
                        for (int counter = 0; counter < 45; counter++) {
                            int num = counter + 1;
                            results += num + " was a jackpot number "
                                    + jackpotnumbers[counter] + "times.\n";
                        }
                    } else {
                        if ((args[1].toUpperCase()).contentEquals("A"))
                            results = "An Analsis of Jackpot and Bonus Numbers for the entire file";
                        else if ((args[1].toUpperCase()).contentEquals("R"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all regular draws";
                        else if ((args[1].toUpperCase()).contentEquals("S"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all special draws";
                        else if ((args[1].toUpperCase()).contentEquals("LP1"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 1 draws";
                        else
                            results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 2 draws";
                        if (numb == 2)
                            results += " on Wednesday draws.\n\n";
                        else if (numb == 1)
                            results += " on Saturday draws.\n\n";
                        else
                            results += " for all draws.\n\n";
                        for (int counter = 0; counter < 45; counter++) {
                            int num = counter + 1;
                            results += num + " was a bonus number "
                                    + bonusnumbers[counter]
                                    + "times and a jackpot number "
                                    + jackpotnumbers[counter] + "times.\n";
                        }
                    }
                }
                if (args.length == 5) {
                    int numb = Integer.parseInt(args[2]);
                    if (choice == 1) {
                        if ((args[1].toUpperCase()).contentEquals("A"))
                            results = "An Analysis of Jackpot Numbers for the entire file";
                        else if ((args[1].toUpperCase()).contentEquals("R"))
                            results = "An Analysis of Jackpot Numbers for all regular draws";
                        else if ((args[1].toUpperCase()).contentEquals("S"))
                            results = "An Analysis of Jackpot Numbers for all special draws";
                        else if ((args[1].toUpperCase()).contentEquals("LP1"))
                            results = "An Analysis of Jackpot Numbers for all Lotto Plus 1 draws";
                        else
                            results = "An Analysis of Jackpot Numbers for all Lotto Plus 2 draws";
                        if (numb == 2)
                            results += " on Wednesday draws\n\n";
                        else if (numb == 1)
                            results += " on Saturday draws\n\n";
                        else
                            results += " for all draws\n\n";
                        results += "for " + args[3] + ".\n\n";
                        for (int counter = 0; counter < 45; counter++) {
                            int num = counter + 1;
                            results += num + " was a jackpot number "
                                    + jackpotnumbers[counter] + "times.\n";
                        }
                    } else {
                        if ((args[1].toUpperCase()).contentEquals("A"))
                            results = "An Analsis of Jackpot and Bonus Numbers for the entire file";
                        else if ((args[1].toUpperCase()).contentEquals("R"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all regular draws";
                        else if ((args[1].toUpperCase()).contentEquals("S"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all special draws";
                        else if ((args[1].toUpperCase()).contentEquals("LP1"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 1 draws";
                        else
                            results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 2 draws";
                        if (numb == 2)
                            results += " on Wednesday draws";
                        else if (numb == 1)
                            results += " on Saturday draws";
                        else
                            results += " for all draws";
                        results += "for " + args[3] + ".\n\n";
                        for (int counter = 0; counter < 45; counter++) {
                            int num = counter + 1;
                            results += num + " was a bonus number "
                                    + bonusnumbers[counter]
                                    + "times and a jackpot number "
                                    + jackpotnumbers[counter] + "times.\n";
                        }
                    }
                }
                if (args.length == 5) {
                    int numb = Integer.parseInt(args[2]);
                    if (choice == 1) {
                        if ((args[1].toUpperCase()).contentEquals("A"))
                            results = "An Analysis of Jackpot Numbers for the entire file";
                        else if ((args[1].toUpperCase()).contentEquals("R"))
                            results = "An Analysis of Jackpot Numbers for all regular draws";
                        else if ((args[1].toUpperCase()).contentEquals("S"))
                            results = "An Analysis of Jackpot Numbers for all special draws";
                        else if ((args[1].toUpperCase()).contentEquals("LP1"))
                            results = "An Analysis of Jackpot Numbers for all Lotto Plus 1 draws";
                        else
                            results = "An Analysis of Jackpot Numbers for all Lotto Plus 2 draws";
                        if (numb == 2)
                            results += " on Wednesday draws\n\n";
                        else if (numb == 1)
                            results += " on Saturday draws\n\n";
                        else
                            results += " for all draws\n\n";
                        results += "between " + args[3] + " and " + args[4]
                                + ".\n\n";
                        for (int counter = 0; counter < 45; counter++) {
                            int num = counter + 1;
                            results += num + " was a jackpot number "
                                    + jackpotnumbers[counter] + "times.\n";
                        }
                    } else {
                        if ((args[1].toUpperCase()).contentEquals("A"))
                            results = "An Analsis of Jackpot and Bonus Numbers for the entire file";
                        else if ((args[1].toUpperCase()).contentEquals("R"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all regular draws";
                        else if ((args[1].toUpperCase()).contentEquals("S"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all special draws";
                        else if ((args[1].toUpperCase()).contentEquals("LP1"))
                            results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 1 draws";
                        else
                            results = "An Analysis of Jackpot and Bonus Numbers for all Lotto Plus 2 draws";
                        if (numb == 2)
                            results += " on Wednesday draws";
                        else if (numb == 1)
                            results += " on Saturday draws";
                        else
                            results += " for all draws";
                        results += "between " + args[3] + " and " + args[4]
                                + ".\n\n";
                        for (int counter = 0; counter < 45; counter++) {
                            int num = counter + 1;
                            results += num + " was a bonus number "
                                    + bonusnumbers[counter]
                                    + "times and a jackpot number "
                                    + jackpotnumbers[counter] + "times.\n";
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, results, "Analysing the Lotto", 1);
    }
}