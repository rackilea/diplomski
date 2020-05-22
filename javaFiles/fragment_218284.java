CharSequence[] fonts = {"cous_font1","cous_font2","cous_font3"};



builder1.setSingleChoiceItems(fonts, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){

                            case 0:
                                typeface = Typeface.createFromAsset(getAssets(), "font1_ttf");
                                yourtextView.setTypeface(typeface);
                                break;
                            case 1:
                                typeface2 = Typeface.createFromAsset(getAssets(), "Font2_ttf");
                                yourtextView.setTypeface(typeface2);
                                break;
                            case 2:
                                typeface2 = Typeface.createFromAsset(getAssets(), "font3_ttf");
                                yourtextView.setTypeface(typeface2);