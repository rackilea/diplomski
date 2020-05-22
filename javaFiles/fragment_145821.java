// Field in the page:
boolean restartRequired = false;


getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    restartRequired = true;
  }
});


@Override
public boolean performOk()
{ 
  if (restartRequired) {
    ... prompt / restart
  }
  return super.performOk();
}