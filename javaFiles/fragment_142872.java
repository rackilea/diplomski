StringBuilder line = new StringBuilder();
StringBuilder values = new StringBuilder();

for(;temp!=null;temp = temp.next) {

  String value =Integer.toString(temp.data.Value);

  line.append("-");
  values.append("|");

  for(int i=0; i<value.length(); i++) { line.append("-"); }
  values.append(value);
}

line.append("-");
values.append("|");

System.out.println(line.toString());
System.out.println(values.toString());
System.out.println(line.toString());