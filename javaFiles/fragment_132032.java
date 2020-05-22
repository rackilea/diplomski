public class PreferenceUtil extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

StringFieldEditor secretSFE;

@Override
public void init(IWorkbench arg0) {
    setPreferenceStore(Activator.getDefault().getPreferenceStore());
}


@Override
protected void createFieldEditors() {

        secretSFE = new StringFieldEditor("secret", "&Secret:\t\t",getFieldEditorParent()){

        @Override
        protected void doFillIntoGrid(Composite parent, int numColumns) {
            super.doFillIntoGrid(parent, numColumns);

            getTextControl().setEchoChar('*');
        }

    };
    addField(secretSFE);

    Activator.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if("secret".equalsIgnoreCase(event.getProperty())){
                String valueToEncrypt = (String)event.getNewValue();
                valueToEncrypt = ConnectionValues.convert(valueToEncrypt);
                secretFFE.setStringValue(valueToEncrypt);
            }
        }
    });      
  }
}