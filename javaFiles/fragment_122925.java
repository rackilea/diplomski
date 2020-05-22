public void onClick(View v) {
    switch (v.getId()){

    case R.id.bNext:
///function calling  
       a++;
       setImage(a);            
        break;

    case R.id.bPrevious:
        if(a>0)
        {
            a--;
            setImage(a);  
            break;
        }

    }

}
private void setImage(int a)
    {   
        if (a == 0)
        {
        slika.setImageResource(R.drawable.p2);
        }
        else if (a == 1)
        {
        slika.setImageResource(R.drawable.p3);
        }
        else if (a == 2)
        {
        slika.setImageResource(R.drawable.p4);
   .
   .
   .
   .
        }
        else if (a == 56)
        {
            startActivity(new Intent("com.example.apps.MENU"));
            finish();
        }
 }