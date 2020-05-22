convertView.setOnClickListener(new View.OnClickListener() {                  
                @Override
                public void onClick(View v) {
                  int position_from = position;
                  Log.i("TRY", Float.toString(position_from));
                  Intent intent = new Intent(context,FbLoginActivity.class);
                  context.startActivity(intent);            
                }
            });