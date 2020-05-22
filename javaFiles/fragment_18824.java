public Class CalculatedValues {
     private int measuredDepth;
     private double mudInActivePits;

     public static CalculatedValues makeNew() {
          return new CalculatedValues();
     }

     public void setMeasuredDepth(String measuredDepthTString) {
           if (measuredDepthTString == null) {
                throw new IllegalArgumentException("The measured depth must be provided.");
           }
           try {
                this.measuredDepth = Integer.parseInt(measuredDepthTString);
           } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("The value provided is not an interger.");
           }
     }
     public int getMeasuredDepth() {
          return measuredDepth;
     }

     public void setMudInActivePitsT(String mudInActivePitsTString) {
           if (mudInActivePitsTString == null) {
                throw new IllegalArgumentException("The measured mudInActivePits must be provided.");
           }
           try {
                this.mudInActivePits = Double.parseDouble(measuredDepthTString);
           } catch(NumberFormatException nfe) {
                throw new IllegalArgumentException("The value provided is not an double.");
           }
     }
     public double getMeasuredDepth() {
          return mudInActivePits;
     }

     //...
     //...
     // MORE THE OTHER VALUES/PROPERTIES IMPORTANT/NEEDED BY THE CALCULATION. 

     public void doAllCalculations() {
          // YOU HAVE TO IMPLEMENT THE LOGIC FOR THOSE ONES, OPTIONALLY USING THE SAME UTILITY/HELPER STATIC METHODS FROM 
          setPressureBeforeCasingBurstAndFormationFracture();
          setCirculatingPressures();
          setTriplexPumpCapacity();
     }
}