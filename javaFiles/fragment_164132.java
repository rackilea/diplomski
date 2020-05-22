final JTextComponent tcA = (JTextComponent) comboA.getEditor().getEditorComponent();
tcA.getDocument().addDocumentListener(new DocumentListener() { 
  ... code that uses comboA ...
});

final JTextComponent tcB = (JTextComponent) comboB.getEditor().getEditorComponent();
tcB.getDocument().addDocumentListener(new DocumentListener() { 
  ... code that uses comboB ...
});