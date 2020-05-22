String st = s.substring(i,i+1);
if(t.contains(st)) {
    sb.append(t.get(st));
} else {
    sb.append(st);
}