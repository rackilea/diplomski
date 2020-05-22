if (select a)
     {
         Intent intent = new Intent(1st.this, a.class); 
         Bundle b = new Bundle();
         b.putInt("data", shareInt);
         intent.putExtras(b);
         startActivity(intent);
     }
else if (select b)
     {
          Intent intent = new Intent(1st.this, b.class); 
          Bundle b = new Bundle();
          b.putInt("data", shareInt);
          intent.putExtras(b);
          startActivity(intent);
     }