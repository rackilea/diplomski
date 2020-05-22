StringBuilder sb = new StringBuilder();
for (Map.Entry<Integer, String> entry : kodovi.entrySet()) {
    sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
}

textArea.setText(sb.toString());