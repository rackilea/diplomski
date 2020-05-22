public final static int REQUEST_CODE_B = 1;
public final static int REQUEST_CODE_C = 2;
...

Intent i = new Intent(this, ActivityB.class);
i.putExtra(...);    //if you need to pass parameters
startActivityForResult(i, REQUEST_CODE_B);

...

//and in another place:
Intent i = new Intent(this, ActivityC.class);
i.putExtra(...);    //if you need to pass parameters
startActivityForResult(i, REQUEST_CODE_C);