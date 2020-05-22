a = x1_tf.getText().toString();
double x1 = Integer.parseInt(a);

a = y1_tf.getText().toString();
double y1 = Integer.parseInt(a);

a = x2_tf.getText().toString();
double x2 = Integer.parseInt(a);

a = y2_tf.getText().toString();
double y2 = Integer.parseInt(a);

Math.sqrt( Math.pow( (x1 - x2) , 2 ) - Math.pow( (y1 - y2) , 2) );