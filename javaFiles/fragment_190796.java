String line;
System.out.println(".....reader.readLine().........."+reader.readLine());

while((line=reader.readLine())!=null)
{
  builder.append(line);
  System.out.println("....builder.append(line);..."+builder.append(line));
}