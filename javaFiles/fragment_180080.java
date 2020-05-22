int count = 0;
int intScoresArr[] = new int [500];
String line;

while((line = BR.readLine()) != null) {
    intScoresArr[count] = Integer.parseInt(line.trim());
    count++;
}