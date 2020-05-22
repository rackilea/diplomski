String str = "Na Adam ne ne yere Hawa: Na Adam xwoo xbabarima";
        String stringToColor = "Adam"; 
        int ofe = str.indexOf(stringToColor,0);   
        Spannable WordtoSpan = new SpannableString(str);

for(int ofs=0;ofs<str.length() && ofe!=-1;ofs=ofe+1)
{       


      ofe = str.indexOf(stringToColor,ofs);   
          if(ofe == -1)
              break;
          else
              {                       

              WordtoSpan.setSpan(new BackgroundColorSpan(Color.YELLOW), ofe, ofe+stringToColor.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
              textView.setText(WordtoSpan, TextView.BufferType.SPANNABLE);
              }


}