final String data = "data 1 class X\ndata 2 class Y\ndata 3 class X";
final Scanner sc = new Scanner(data);
final HashMap<String, Integer> classes = new HashMap<String, Integer>();
while (sc.hasNextLine()) {
    final String line = sc.nextLine();
    final String clazz = line.substring(line.indexOf("class")+6);

    if (!classes.containsKey(clazz))
        classes.put(clazz, 0);
    classes.put(clazz, classes.get(clazz)+1);
}

for (Entry<String, Integer> entry : classes.entrySet())
    System.out.println("Class "+entry.getKey()+" found "+entry.getValue()+" time(s).");