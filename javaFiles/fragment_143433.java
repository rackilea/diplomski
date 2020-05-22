countButton.setOnClickListener(this);

public void onClick(View view)
{
Intent intent = new Intent(MainActivity.this,AddEditAccount.class);
                MainActivity.this.startActivity(intent);
}