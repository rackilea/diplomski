JTextArea editor = new JTextArea(10, 10);
editor.setEditable(false);
int min = 0;
int max = 10;
StringBuilder sb = new StringBuilder(128);
for (int n = min; n <= max; n++) {
    editor.append(Integer.toString(n) + "\n");
}