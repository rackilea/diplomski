function FullyCollapseCurrentScript()

%// Get the relevant javax.swing.text.JTextComponent:
jTc = com.mathworks.mlservices.MLEditorServices ...
        .getEditorApplication.getActiveEditor.getTextComponent();
%// Get the FoldHierarchy for the JTextComponent:
jFh = org.netbeans.api.editor.fold.FoldHierarchy.get(jTc);
%// Finally, collapse every possible fold:
org.netbeans.api.editor.fold.FoldUtilities.collapseAll(jFh);

end