JSpinner component = ...;

component.setEnabled( false );
if ( component.getEditor() instanceof JSpinner.DefaultEditor ) {
   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) component.getEditor();
   editor.getTextField().setEnabled( true );
   editor.getTextField().setEditable( false );
}