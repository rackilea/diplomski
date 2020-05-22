public void runAddValidation()
{
    double vluRaised = 0l;
    boolean vTypeDistanceBroke;
    String current = "d";
    double vFigure = vluRaised;

    try 
    { 
        vluRaised = Double.parseDouble(current);

        vTypeDistanceBroke=false; 
    }

    catch (NumberFormatException nfe) 
    { 
        vTypeDistanceBroke=true; 
        System.out.println("Type-MoneyRaised: Failed"); 
        JOptionPane.showMessageDialog(null, "Please add a valid value (No Letters)");
    }
}