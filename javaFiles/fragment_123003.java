JLabel label = new JLabel();
int min = 0;
int max = 10;
StringBuilder sb = new StringBuilder(128);
for (int n = min; n <= max; n++) {
    sb.append(n);
}
label.setText(sb.toString());