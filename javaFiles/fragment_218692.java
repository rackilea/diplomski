Object obj = rs.getObject(index);
if (obj instanceof Array)
{
   obj = ((Array) obj).getArray();
}
returnMap.put(rsmd.getColumnName(index), obj);