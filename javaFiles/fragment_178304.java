int count = 0;
String line;
while ((line = br.readLine()) != null) {
    if (count % 2 == 0) {
        // do something with this line
    }
    ++count;
}