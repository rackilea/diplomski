public String printAll()
{
    String s = "";

        for(myNodes tmp=head;tmp!=null;tmp=tmp.next)
          s += tmp.toString();


return s;
}