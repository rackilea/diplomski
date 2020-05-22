AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
        builder.setTitle("Title");
        builder.setMessage("message");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();