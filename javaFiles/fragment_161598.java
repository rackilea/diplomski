StringBuilder sb=new StringBuilder();

for(int i = 1; i <= numberOfColumns; i++)
{
    sb.append(String.format("| %-10s",rsMetaData.getColumnLabel(i)));
}