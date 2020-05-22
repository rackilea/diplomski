IContributionItem comboCI = new ControlContribution("test") {
protected Control createControl(Composite parent) {

    combo = new Combo(parent, SWT.READ_ONLY);
    combo.add("one");
    combo.add("two");
    combo.add("three");
    combo.addSelectionListener(new SelectionAdapter() {
         public void widgetSelected(SelectionEvent e) {
             combo.add("four");
          }
          });
    return combo;
}
};