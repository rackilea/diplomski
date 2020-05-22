RelativeLayout container = (RelativeLayout) holder.imageview.getParent();
container.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d("test", "clicked");
                    RelativeLayout cont = (RelativeLayout) v;
                    CheckBox cb = (CheckBox) cont.getChildAt(1);
                    if(cb.isChecked()) cb.setChecked(false);
                    else cb.setChecked(true);
                }
            });