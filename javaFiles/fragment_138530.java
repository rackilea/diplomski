JTextArea textArea = new JTextArea(10,names.length);
textArea.setEditable(false);

for(int i=0; i<names.size; i++){
    textArea.append("Book " + i + "#: " + names[i] + "\n");
}

panel.add(textArea);