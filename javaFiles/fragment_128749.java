List<String> lines = new ArrayList<>();
while (sc.hasNextLine()) {
    lines.add(sc.nextLine());
}

array2 = new char[lines.size()][];
for (int i = 0; i < array2.length; i++) {
    array2[i] = lines.get(i).toCharArray();
}