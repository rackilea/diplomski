int n = 3;
StringBuilder sb = new StringBuilder();
for (int i = 0; (line = fileRead.readLine()) != null; i++) {
     if (i % n == 0) {
        sb.delete(0, line.length())
        System.out.println(sb.append(line).reverse());
     }
}