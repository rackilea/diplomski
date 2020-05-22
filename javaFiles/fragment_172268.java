@Override
public void update(AjaxRequestTarget target, boolean state) {
   for (int i = 0; i < rowsCheckboxes.size(); i++) {
      CustomCheckbox checkbox = rowsCheckboxes.get(i);
      checkbox.setState(state);            
   }
   String setStateAllCheck = "your script code to select/unselect all checkboxes";
   target.prependJavaScript()
}