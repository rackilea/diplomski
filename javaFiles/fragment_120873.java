for(String entry : mapA.keySet())
{
  Integer mapAvalue = (Integer) mapA.get(entry);
  String  token1=entry.substring(0, entry.indexOf(" "));
  String  token2=entry.substring(entry.indexOf(" "),entry.length()).trim();

  if(mapb.containsKey(token1) && mapb.containskey(token2))
  {
       // look up the tokens:
       Integer tokenVal1=(Integer)mapb.get(token1);
       Integer tokenVal2=(Integer)mapb.get(token2);

       if(tokenVal1>1000 && tokenVal2>1000)
       {
            **procedurecall(mapAvalue, token1, token2, tokenVal1, tokenVal2);**
       }
  }