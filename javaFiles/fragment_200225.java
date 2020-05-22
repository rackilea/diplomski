String name = file.getName();
name = name.subString(0, name.lastIndexOf("."));
name += ".html";
File newFile = new File(file.getParentFile(), name);
if (file.renameTo(newFile)) {
    TableToCSV tableToCSV = new TableToCSV( newFile, ',', '\"', '#', CSV.UTF8Charset );
}