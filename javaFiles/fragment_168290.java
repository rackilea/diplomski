public class Conversion{

    // Removed the CmToMConversion method

    // Make methods static
    public static String MilesToCmConversion(String milesToCm){
        try{
            double mil = Double.parseDouble(milesToCm);
            double cm = mil * 160934.4;
            return String.format("%3.1f", cm);
        } catch (NumberFormatException exception){
            return "0";
        }
    }

    // Copy the rest of your methods into the class here
    // and make them static like above
}