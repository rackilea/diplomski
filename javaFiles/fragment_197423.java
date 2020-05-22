private void displayInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    for (ArrayList<String> arrayList: outerArrayList) {
        for (String s: arrayList) {
            sb.append(s);
            sb.append('\n');
        }
    }
    String yourInfo = stringBuilder.toString();
    yourTextView.setText(yourInfo); // assumes your textEdit is multiline
}