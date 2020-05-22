StringBuilder sb = new StringBuilder();
for(String str: split){
    if (!hset.contains(str)) {
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(str);
    }
}
System.out.println("\n" + "\n" + sb.toString());