LayoutParams params;

Button btnConnect = new Button(this);
params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
params.gravity = Gravity.Left;
btnConnect.setLayoutParams(params);
...
Button btnDisconnect = new Button(this);
params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
params.gravity = Gravity.Right;
btnConnect.setLayoutParams(params);
...