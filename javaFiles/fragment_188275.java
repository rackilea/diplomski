import javax.swing.*; // import swing lib for i/o
public class Arrays4
{
     static String[] person = new String[4];//these have been made global and static
     static int[] votescount = new int[4];
    public static void main (String[] args)
    {
        // Initialize String Arrays
        person[0] = "person1";//these have been moved so that it is only called once
        person[1] = "person2";
        person[2] = "person3";
        person[3] = "person4";
        // Initialize int Arrays

        votescount[0] = 0;
        votescount[1] = 0;
        votescount[2] = 0;
        votescount[3] = 0;


        voteperson();
        voterepeat();
        System.exit(0);
    } // end method main

    public static int voteperson()
    {
        // Declare String Variables
        String userinput;
        userinput = JOptionPane.showInputDialog
        ("Please tell us which painting you think is the best."+"\n"+
        "Vote 1 "+person[0]+"\n"+
        "Vote 2 "+person[1]+"\n"+
        "Vote 3 "+person[2]+"\n"+
        "Vote 4 "+person[3]);

        int answer = Integer.parseInt(userinput);
        System.out.println(answer);
        int i;


            if (answer == 1)
            {
                votescount[0] = votescount[0]+1;
            }
            else if (answer == 2)
            {
                votescount[1] = votescount[1]+1;
            }
            else if (answer == 3)
            {
                votescount[2] = votescount[2]+1;
            }
            else if (answer == 4)
            {
                votescount[3] = votescount[3]+1;
            }
            else
            {

            }


        JOptionPane.showMessageDialog
        (null, "The current votes are" + "\n" +
        votescount[0] + " :" + person[0] + "\n" +
        votescount[1] + " :" + person[1] + "\n" + 
        votescount[2] + " :" + person[2] + "\n" +
        votescount[3] + " :" + person[3]);

        return 0;
    }
    public static void voterepeat()
    {
        for (int j=1; j<=4; j++)
        {
            int repeat;
            repeat = voteperson();
            System.out.println(j);
        }
    }
}