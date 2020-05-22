StringBuilder sb = new StringBuilder();
sb.append("");
for (int j = 0; j < songTitle.size(); j++) {
  sb.append(j);
  sb.append("- ");
  sb.append(songTitle.get(j));
  sb.append(" ");
}
nameOutput.setText(sb.toString());