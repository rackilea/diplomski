public void run() {
    String file_name = "text/test.txt";
    try {
        ReadFile file = new ReadFile(file_name);
        String[] aryLines = file.OpenFile();

        StringBuilder innerText = new StringBuilder();
        for (int i = 0; i < aryLines.length; i++) {
            if (aryLines[i].equals("5")) {
                break;
            } else {
                innerText.append(aryLines[i]).append("<br/>");
            }
        }
        label.setText("<html>" + innerText.toString() + "</html>");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}