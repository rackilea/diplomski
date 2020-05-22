final String lineSeparator = System.getProperty("line.separator");

// setup the header line
StringBuilder sb = new StringBuilder("your,header,line,stuff");
sb.append(lineSeparator);

// now append your data in a loop
for (i = 0; i < list1.size(); i++) {
    sb.append(list1.get(i));
    sb.append(",");
    sb.append(list2.get(i));
    sb.append(",");
    sb.append(list3.get(i));
    sb.append(lineSeparator);
}

// now write to file
Files.write(Paths.get("path/to/where/you/want/output.csv"), sb.toString().getBytes());