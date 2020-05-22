row.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
          if(!isLongPressed){
            isLongPressed = true;
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            ImageView imageView = new ImageView(getContext());
            byte[] bytes = Base64.decode(erhebung.getPic(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            imageView.setImageBitmap(bitmap);
            imageView.setPadding(10,10,10,10);
            adb.setView(imageView);
            dialog = adb.create();
            dialog.show();
          }
            return true;
        }
    });
    row.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            v.onTouchEvent(event);
            System.out.println("1");
            if (event.getAction() == MotionEvent.ACTION_UP) {
                System.out.println("2");
                if (isLongPressed) {
                    dialog.cancel();
                    System.out.println("canceld");
                    isLongPressed = false;
                }
            }
            return false;
        }
    });