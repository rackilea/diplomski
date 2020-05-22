public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

           switch (which){

            case 0 :
                    String str = items[which];
                //do something

            case 1:

                Intent intent = new Intent (MyActivity.this, WebViewActivity.class);
                MyActivity.this.startActivity(intent);


            }
        });