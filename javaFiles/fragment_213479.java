int a[] = new int[n];
String line = br.readLine(); // to read multiple integers line
String[] strs = line.trim().split("\\s+");
for (int i = 0; i < n; i++) {
    a[i] = Integer.parseInt(strs[i]);
}