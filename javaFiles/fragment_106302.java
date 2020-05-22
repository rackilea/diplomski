AlertDialog.Builder third = new 
                AlertDialog.Builder(MainActivity.this);
                third.setTitle("TITLE");
                third.setMessage("MESSAGE");
                third.setPositiveButton("Przykład", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    AlertDialog.Builder help = new AlertDialog.Builder(MainActivity.this);
                    help.setTitle("Title");
                    help.setMessage("Message");
                    help.setPositiveButton("Stop", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    help.show();
                }
            });
            third.show();