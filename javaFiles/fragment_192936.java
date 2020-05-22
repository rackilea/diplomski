holder.editbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"edit"+listClient.getCustomername(),Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(v.getRootView().getContext())
                .setMessage("client"+listClient.getCustomername())
                .setTitle("Client Status update")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Result","Success");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Result","Success");
                    }
                })
                .show();

    }

});