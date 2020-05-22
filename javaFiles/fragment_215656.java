List<String> javaNames = new ArrayList<>();
for (int i=0; i<l; i++)
    if (fileNames[i].endsWith(".java"))
        javaNames.add(fileNames[i]);
System.out.println(javaNames);
return javaNames.toArray(new String[javaNames.size()]);