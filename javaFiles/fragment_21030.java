int[] values= new int[2];
view.getLocationOnScreen(values);
int x = values[0];
int y = values[1] ;

toast.setGravity(Gravity.TOP|Gravity.LEFT, x, y);