resultTF = new JTextArea();
Font f = resultTF.getFont();
resultTF.setFont(new Font(Font.MONOSPACED, f.getStyle(), f.getSize()));

add(new JScrollPane(resultTF));

.
.
.

for(int i = 0; i < height; i++) {
    for(int j = 0; j < width; j++) {
        resultTF.append(".");
    }
    resultTF.append("\n");
}