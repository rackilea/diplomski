String s = "{{\"2D\", \"array\"}, {\"represented\", \"in a string\"}}";
s = s.replace("{", "");
String[] s0 = s.split("},\\s");
int length = s0.length;
String[][] a = new String[length][];
for (int i = 0; i < length; i++) {
    a[i] = s0[i].replace("}", "").split(",\\s");
}