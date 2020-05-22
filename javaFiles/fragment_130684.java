@Override
public void onClick(View v) {
    switch (v.getId()) {
    case R.id.enter:
        String in = cl.getText().toString();
        String[] Input = in.split(",");
        // I would like to send Input[] to the line Thread in DrawingUtils
        callEnter.start();
        break;
    case R.id.line:
        callLine.start();
        break;
    case R.id.arc:
        callArc.start();
        break;
    }
};