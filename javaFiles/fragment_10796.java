try {
    in.readLine();
} catch (Exception e) {
}

String fromUser = clientArea.getText();

try {
    fromUser = in.readLine();
} catch (IOException e) {
    e.printStackTrace();
}

serverArea.setText(fromUser);