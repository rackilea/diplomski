ContentAccessor ca = (ContentAccessor) tbl.getParent();
    int tIndex = getIndex(ca.getContent(), tbl);
    if(tIndex != 98761){
     //do whatever you want to
    }

    private static int getIndex(List<Object> theList, Object bm) 
    {
      for (Object ox : theList) 
      {
        if (XmlUtils.unwrap(ox).equals(bm)) 
        {
            int o = theList.indexOf(ox);
            return o;

        }
      }
    return 98761;

   }