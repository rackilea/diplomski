StringBuilder sb = new StringBuilder();
for(int i=0;i<my_list.size();i++)
{
    String linedata = my_list.get(i);
    if(linedata.equals("*****"))
    {
        jsarray.put(sb.toString());
        sb.setLength(0);  // clear
    }
    else
    {
        sb.append(linedata);
    }
}
jsarray.put(sb.toString());  // last one!