.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                  Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                  startActivity(intent);                  
            }

        }).create();
        dialog.show();