FileWriter fw = new FileWriter(new File(absolute_new_file_name));
while (line_info != null) {
    String convertQuery = convertQuery(line_info);
    if(convertQuery.isEmpty()) {
        line_info = br.readLine();
        continue;
    }
    new_query.append(convertQuery);
    new_query.append(System.getProperty("line.separator"));
    fw.write(new_query.toString());
    new_query.setLength(0);
    line_info = br.readLine();
}