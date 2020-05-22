final StringBuilder sb = new StringBuilder();
for (String line = readIt.nextLine(); line != null; line = readIt.nextLine()) {
    sb.append(line);
    sb.append("\n");
}

GraphicGameBoard.topScoreDisplay.setText(sb.toString());