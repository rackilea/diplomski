// sourceDateChooser and targetDateChooser MUST be final, 
// since they will be accessed inside a anonymous inner class

sourceDateChooser.addPropertyChangeListener( new PropertyChangeListener(){
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // the docs of JDateChooser says that when the date is modified, a "date" property change is fired
        if ( evt.getPropertyName().equals( "date" ) ) {
            targetDateChooser.setDate( sourceDateChooser.getDate() );
        }
    }
});