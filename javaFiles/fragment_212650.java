BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
int emptyCount = 0;

String line;
while (emptyCount < 3 && (line = br.readLine()) != null) {
     System.out.println (line);

     /* Track Empty Lines Count */
     if(String.isEmpty(line)) {
          emptyCount++;
     } else {
          emptyCount = 0;
     }
}