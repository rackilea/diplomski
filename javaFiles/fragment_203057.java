StringBuilder sb = new StringBuilder();
while(cellIterator.hasNext())
{
sb.append(cellIterator.next().toString());
sb.append(";");
}
sg.setStr(sb.toString());