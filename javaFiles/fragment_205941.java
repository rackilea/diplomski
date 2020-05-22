StringBuilder sb = new StringBuilder();
for (String s : urlList) {
    sb.append("<a href=").append(s).append(">").append(s).append("</a>\n");
}

ResultsArea.setText(sb.toString()); // then set the complete URL list once