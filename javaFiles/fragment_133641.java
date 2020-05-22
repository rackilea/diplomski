Intent i = new Intent(this, YourActivity.class);
Bundle b = new Bundle();

b.putInt("intName",intValue);
i.putExtras(b);
startActivity(i);