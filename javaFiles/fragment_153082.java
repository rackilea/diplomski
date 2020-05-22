case KeyEvent.KEYCODE_BACK:
                    AlertDialog ad = new AlertDialog.Builder(myActivity)
                    .setTitle("EXIT?")
                    .setMessage("Do you really want to exit?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((Cocos2dxActivity)myActivity).finish();
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
                    ad.show();
            return true;
        case KeyEvent.KEYCODE_MENU: