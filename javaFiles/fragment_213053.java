String delimiter = ", ";
StringBuilder sb = new StringBuilder();

if (!array.isEmpty()) {
    sb.append('"').append(array.get(0)).append('"');
}
for (int i = 1; i < array.size(); i++) {
    sb.append(delimiter).append('"').append(array.get(i)).append('"');
}

String result = sb.toString();