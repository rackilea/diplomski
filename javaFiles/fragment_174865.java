ArrayList<String> values = // ... built somewhere
StringBuilder sb = new StringBuilder();
for (String v : values) {
  sb.append(v);
}
out.println(sb.toString());