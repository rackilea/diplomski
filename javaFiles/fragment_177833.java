@Override
        public boolean setViewValue(View view, Cursor cursor, int column) {
            if( column == col ){ 
                ImageView img = (ImageView) ((View)view.getParent()).findViewById(R.id.icon);
                if(cursor.getString(col).equals("Y"))
                {
                    img.setBackgroundResource(R.drawable.img1);
                }
                else
                {
                    img.setBackgroundResource(R.drawable.img2);                        
                }
                return true;
            }
            return false;
        }
    });