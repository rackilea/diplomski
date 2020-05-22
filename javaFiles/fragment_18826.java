@Override
public void focusLost(FocusEvent e) {
    try {
        if(e.getSource() == measuredDepthT) { 
            //KillWellCalculations.measuredDepth = Integer.parseInt(measuredDepthT.getText());
            // the exceptions thrown can be caught in the catch below and you can display the error message from the value class.
            calculatedValues.setMeasuredDepth(measuredDepthT.getText());

          ...//Others 

            // collect other values as well...

        } else if(e.getSource() == mudInActivePitsT) {
            //KillWellCalculations.mudInActivePits = Double.parseDouble(mudInActivePitsT.getText());
            // do try/catch for the possible runtime exception and display an error message
            calculatedValues.setMudInActivePitsT(mudInActivePitsT.getText());

        }
    } catch (Exception ignore) { 
    }

}