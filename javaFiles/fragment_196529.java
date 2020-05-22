//...
while ((line = br.readLine()) != null) {
    String[] values = line.split("\t");
    if (values.length >= 1 && values.length <= 2)
        tasks.add(new DueDate(values[0], values.length == 1 ? "" : values[1]));
}
//...