Collections.sort(var4, new Comparator<TreeMap>() 
{
     public int compare(TreeMap var1, TreeMap var2) 
     {
        return ((String)var1.get("col_3")).compareTo((String)var2.get("col_3"));
     }
});