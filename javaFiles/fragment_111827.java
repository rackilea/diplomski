package finalproject;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Initialize a common Scanner
        final Scanner scan = new Scanner(System.in);

        // User Information
        LoginInformation.loginInfo(scan);

        // Questions that should be print in the screen
        ProgramInterFace.interFace(scan);
    }
}