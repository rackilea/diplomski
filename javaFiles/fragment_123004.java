JLabel label = new JLabel();
int min = 0;
int max = 10;
StringBuilder sb = new StringBuilder(128);
sb.append("<html>");
for (int n = min; n <= max; n++) {
    System.out.println(Integer.toString(n));
    sb.append(n).append("<br>");
}
sb.append("</html>");
label.setText(sb.toString());