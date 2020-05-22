Submitted On 09-MAR-2010

The change is in the BasicButtonListener -  Method focusLost()

In 1.6.0_18 it is

       ...
       ButtonModel model = b.getModel();
       model.setPressed(false);
       model.setArmed(false);

in 1.6.0_10 it was

       ...
       ButtonModel model = b.getModel();
       model.setArmed(false);
       model.setPressed(false);

(The order of the statements changed)

And a setPressed(false) with armed==true leads on an ToggleButton like 
the JCheckBox to a change of the selection (see ToggleButtonModel)