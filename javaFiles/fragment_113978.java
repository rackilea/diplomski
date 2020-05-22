public void onClick(View v) {
                final Intent intent;

                int position = getAdapterPosition();

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                String onoff = preferences.getString("it's", "");

//IF IT IS ON DO THIS
                if(onoff.equalsIgnoreCase("on"))
                {
                    if (position==0){

                        intent =  new Intent(context, nose.class);
                        context.startActivity(intent);
                    }

    //IF IT IS OFF DO THIS
                } else if (onoff.equalsIgnoreCase("off")){

                    if (position==0){

                        intent =  new Intent(context, nose2.class);
                        context.startActivity(intent);
                    }
                }
            }