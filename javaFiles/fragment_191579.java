AdapterInterface buttonListener;
public XyzAdapter(Context context, AdapterInterface buttonListener)
{
  super(context,c,flags);
  this.buttonListener = buttonListener;
}

public void onClick(View v) {
      buttonListener.buttonPressed()
}