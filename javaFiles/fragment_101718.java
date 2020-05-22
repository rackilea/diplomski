Scanner aScanner = ...
ArrayList<String> L = new ArrayList<String>();
while(aScanner.hasNextLine()){
    L.add(aScanner.nextLine());
}
int rows = L.size();
String[][] S = new String[rows][];
for (int i = 0; i < rows; i++) {
    S[i] = L.get(i).split(";");
}