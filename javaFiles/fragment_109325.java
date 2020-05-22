StringBuilder sb = new StringBuilder("array" + xx +" is found at index: ");
 for (x = 0; x < v; x++) {
     if (c[x] == xx) {
         sb.append(x).append(",");
     }
 }


if (sb.charAt(sb.length() - 1) == ',') {
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
} else {
    System.out.println("array not found");
}