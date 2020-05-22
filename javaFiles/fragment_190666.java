import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class CST200_Lab2 {

    public static void main(String[] args) throws Exception {
        String inputString = "";

        double hullSpeed;
        double displacementEqu;
        double sailAreaEqu;
        double capSize;
        double comfortIndex;

        // declare variables outside the loop to be preserved
        // initialize at -1 because length and area can't be negative
        // and because my compiler requires initialization
        double lengthVesselDbl = -1;
        double waterLineLengthDbl = -1;
        double widthVesselDbl = -1;
        double displacementDbl = -1;
        double sailAreaDbl = -1;

        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(ISR);

        NumberFormat NF = NumberFormat.getNumberInstance();
        NF.setMaximumFractionDigits(2);
        NF.setMinimumFractionDigits(2);

        System.out.println("Starting program!");

        int i = 1;

        // loop and read input, and assign to proper variable
        while ((inputString = BR.readLine()) != null && (!inputString.equalsIgnoreCase("q"))) {
            try {
                switch (i) {
                case 1:
                    lengthVesselDbl = Double.parseDouble(inputString);
                    break;

                case 2:
                    waterLineLengthDbl = Double.parseDouble(inputString);
                    break;

                case 3:
                    widthVesselDbl = Double.parseDouble(inputString);
                    break;

                case 4:
                    displacementDbl = Double.parseDouble(inputString);
                    break;

                case 5:
                    sailAreaDbl = Double.parseDouble(inputString);
                    break;

                default:
                    System.out.println("Input is not being used. Press Q to exit!");
                    break;
                }
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }

        // check if variables were assigned properly
        if (lengthVesselDbl >= 0 && waterLineLengthDbl >= 0 && widthVesselDbl >= 0 && displacementDbl >= 0
                && sailAreaDbl >= 0) {

            // Calculate the Hull Speed
            hullSpeed = 1.34 * (Math.pow(waterLineLengthDbl, .5));

            // Calculate Displacement to Waterline Length
            displacementEqu = (displacementDbl / 2240.00) / Math.pow((.01 * waterLineLengthDbl), 3);

            // Calculate Sail Area to Displacement
            sailAreaEqu = sailAreaDbl / Math.pow((displacementDbl / 64.00), .67);

            // Calculate the Capsize index.
            capSize = widthVesselDbl / Math.pow((displacementDbl / 64.00), .33);

            // Calculate the Comfort index
            comfortIndex = (displacementDbl)
                    / (.65 * (.7 * waterLineLengthDbl + .3 * lengthVesselDbl) * Math.pow((widthVesselDbl), 1.33));

            // Print out the User input
            System.out.println("LOA: " + NF.format(lengthVesselDbl));
            System.out.println("LWL: " + NF.format(waterLineLengthDbl));
            System.out.println("BEAM: " + NF.format(displacementDbl));
        } else {
            throw new Exception("Dimensions weren't initialized!");
        }
    }
}