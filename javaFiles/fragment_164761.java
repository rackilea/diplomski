/**************************
*
* STR_PAD IMPLEMENTED
*
**************************/
public String str_pad(String input, int length, String pad, String    sense)
{
   int resto_pad = length - input.length();
   String padded = "";

   if (resto_pad <= 0){ return input; }

   if(sense.equals("STR_PAD_RIGHT"))
   {
       padded  = input;
       padded += _fill_string(pad,resto_pad);
   }
   else if(sense.equals("STR_PAD_LEFT"))
   {
       padded  = _fill_string(pad, resto_pad);
       padded += input;
   }
   else // STR_PAD_BOTH
   {
       int pad_left  = (int) Math.ceil(resto_pad/2);
       int pad_right = resto_pad - pad_left;

       padded  = _fill_string(pad, pad_left);
       padded += input;
       padded += _fill_string(pad, pad_right);
   }
   return padded;
}


protected String _fill_string(String pad, int resto )
{
   boolean first = true;
   String padded = "";

   if (resto >= pad.length())
   {
      for (int i = resto; i >= 0; i = i - pad.length())
      {
          if (i  >= pad.length())
          {
              if (first){ padded = pad; } else { padded += pad; }
          }
          else
          {
              if (first){ padded = pad.substring(0, i); } else { padded += pad.substring(0, i); }
          }
          first = false;
      }
  }
  else
  {
      padded = pad.substring(0,resto);
  }
  return padded;
}