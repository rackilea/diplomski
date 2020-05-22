String g = "hi5hi6";
String[] parts = g.split("hi");

for (String part : parts) {
    if (!part.isEmpty()) {
        int p = Integer.parseInt(part);
        System.out.println(p);
    }
}