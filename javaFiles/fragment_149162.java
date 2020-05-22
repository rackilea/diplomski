new Comparator<YourCustomObject>() 
{
      @Override
      public int compare(YourCustomObject  o1, YourCustomObject  o2) 
      {
        return Integer.compare(o1.secondint, o2.secondint); 
      }
}