for(int z = 0, j = 0; z < ctr-1; z++, j++)
{
      if ( j >= flames.length() )
      {
         j = 0; // reset back to the beginning
      }
      res = (flames[j]);
      jLabel1.setText(String.valueOf(res));
}