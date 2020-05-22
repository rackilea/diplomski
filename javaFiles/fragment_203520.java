StateListDrawable states = new StateListDrawable();
int yourBackgroundColor = Color.parseColor("#FFFFFF");
// Add specific color when your view has state 'pressed'
states.addState(new int[] {android.R.attr.state_pressed}, new ColorDrawable(yourBackgroundColor));
// Add other states wanted and associated drawable
// ...
// As StateListDrawable extend Drawable, you can use it as background for exemple       
yourView.setBackground(states);