StringBuilder sb = new StringBuilder();
for (int a = 0; a < 7; a++) {
...
sb.append(a+1).append(": ").append(rank).append(" of ").append(suit).append("\n");
...
String playedCards = sb.toString();
System.out.println(playedCards);