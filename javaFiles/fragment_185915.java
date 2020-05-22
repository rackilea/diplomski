PrintStream ps = new PrintStream(new FileOutputStream(filePath));
while ((data1 = read1.readLine()) != null)
{
    ps.println(data1);
}
ps.close();