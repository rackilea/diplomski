StringBuilder sb = new StringBuilder();
for (String s : Arrays.asList(food, file, parcel, others)) {
    if (s != null) {
        sb.append(s).append('\n');
    }
}
String itemList = sb.toString();