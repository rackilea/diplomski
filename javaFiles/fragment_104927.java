public class SpecialValuesSpinnerEditor extends DefaultEditor implements DocumentListener {

    // You have to do in your contructor
    SpecialValuesSpinnerFormatter formatter = 
        new SpecialValuesSpinnerFormatter (spinner.getSpecialValues(), format);
    getTextField().setFormatterFactory(new DefaultFormatterFactory(formatter));
}