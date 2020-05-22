int j = 0;
while(iResultSet1.next())
{
   j++;
   List expRptColWise = new ArrayList();
   for(Integer i=1;i<=iResultSet1.getMetaData().getColumnCount();i++)
   {
      expRptColWise.add(iResultSet1.getString(i));
   }
   expRptColWise.add(j);
   expRptRowWise.add(expRptColWise);
}