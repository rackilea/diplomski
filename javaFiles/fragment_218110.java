BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int numOfFields = Integer.parseInt(br.readLine());
Pattern sep = Pattern.compile(br.readLine(), Pattern.LITERAL);
String line;
List<Song> songs = new ArrayList<Song>();
while((line = br.readLine()) != null) {
    String[] fields = sep.split(line, numOfFields);
    songs.add(new Song(fields[0], fields[1], fields[2]);
}
Collections.sort(songs);