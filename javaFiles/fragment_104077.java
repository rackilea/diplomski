if (instances.getText().toString().lenght() > 0)
{
 int value = Integer.parseInt(instances.getText().toString());;
        if(value > 10)
            Toast.makeText(getApplicationContext(), "Enter a value between 0 and 10!", Toast.LENGTH_SHORT).show();
        else
            if(value<0)
                Toast.makeText(getApplicationContext(), "Enter a value between 0 and 10!", Toast.LENGTH_SHORT).show();
            else
                if(value >= 0 && value <=10)
                {
                    schimba(v);
                }
}
else
{
  // HANDLE EMPTY VALUE HERE
}