FileItem f = files.get(0);

// there is a problem here where the file being created is empty, since we only have a
// partial path:
DataSource source = new FileDataSource(new File(f.getName()));

// because of the above problem, we are going to copy over the data ourselves:
byte[] sourceBytes = f.get();
OutputStream sourceOS = source.getOutputStream();
sourceOS.write(sourceBytes);