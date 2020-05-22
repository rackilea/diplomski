public static int colorToNumber(String cob, String rr, String oo, String yy, String gg, String bb)
{
  int ret = 0;
  if(rr.equals(cob)){ret = 1;}
  if(oo.equals(cob)){ret = 2;}
  if(yy.equals(cob)){ret = 3;}
  if(gg.equals(cob)){ret = 4;}
  if(bb.equals(cob)){ret = 5;}
  return ret;
}