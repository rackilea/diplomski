if (Desktop.getDesktop().isMacOSX()){
    // see MetalLookAndFeel class for details
    String[] keys = {"TextField.focusInputMap", "PasswordField.focusInputMap", "TextArea.focusInputMap", "TextPane.focusInputMap", "EditorPane.focusInputMap", "FormattedTextField.focusInputMap"};
    //              , "List.focusInputMap", "Table.ancestorInputMap", "Tree.focusInputMap"};
    for(String item : keys){
        InputMapUIResource map = (InputMapUIResource) UIManager.get(item);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.META_MASK), DefaultEditorKit.copyAction);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.META_MASK), DefaultEditorKit.pasteAction);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.META_MASK), DefaultEditorKit.selectAllAction);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.META_MASK), DefaultEditorKit.cutAction);
    }