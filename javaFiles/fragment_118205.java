if(!isFinishing){
    new AlertDialog.Builder(this)
            .setTitle("最終確認")
            .setMessage(order())
            .setPositiveButton("呼ぶ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editor.putBoolean("呼び出し中", true);
                    editor.commit();

                    if( imageupsita ) {
                        uptask = new UploadAsyncTask( Transmission.this );
                        uptask.context = Transmission.this;
                        String filePath = getPathUri(getApplicationContext(), pictureUri);
                        uptask.execute(filePath);
                        imageupsita = false;
                    }


                    //smsPush();
                    exec_post();
                    SaveDatabase();


                    startActivity(new Intent(Transmission.this, Home.class));
                    finish();
();
                    c.close();
                    db.close();

                }

            }).setNegativeButton("確認し直す", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which){
                    return;
                }
            })
            .create()
            .show();
    }