int lowNum = Integer.parseInt(minInput.getText());
int highNum = Integer.parseInt(maxInput.getText());
StringBuilder sb = new StringBuilder(String.valueOf(lowNum));
for (int i = lowNum + 1; i <= highNum; i++) {
    sb.append(", ").append(i);
}
outputLabel.setText(sb.toString());