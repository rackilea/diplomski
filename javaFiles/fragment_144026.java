BufferedReader in = new BufferedReader(new FileReader("Spieler.txt"));
String s1 = new String();
while((s1 = in.readLine()) != null) {
    Highscore.nameHS[i++];
}
in.close();