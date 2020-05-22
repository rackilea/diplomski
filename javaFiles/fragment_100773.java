final ColorPickerDialog d= new ColorPickerDialog(ActivityName.this,0xffffffff);
                d.setAlphaSliderVisible(true);

                d.setButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mPaint.setColor(d.getColor());

                    }
                });

                d.setButton2("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                d.show();