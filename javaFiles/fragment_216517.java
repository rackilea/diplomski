String str = "frequency:50,current:25,voltage:30";

HashMap dict = new HashMap();

for (String s : str.split(",")) {
    dict.put(s.split(":")[0], s.split(":")[1]);
}