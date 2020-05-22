switch(hello) {
                case "Blue":

                    View myView = (View) findViewById(R.id.Blue);
                    ((ViewManager) v.getParent()).removeView(v);

                    break;