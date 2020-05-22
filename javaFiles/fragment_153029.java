activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    AlertDialog.Builder alert = new AlertDialog.Builder(activity);
                    alert.setTitle("");
                    alert.setMessage("");
                    alert.setPositiveButton("Buy", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
                    alert.setNegativeButton("Cancel", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

                    alert.show();
                }
            });