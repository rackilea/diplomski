public void deseaFigurar(){
    final AlertDialog.Builder builder= new AlertDialog.Builder(this);
    LayoutInflater inflater = this.getLayoutInflater();

    View dialogView = inflater.inflate(R.layout.dialog, null);
    builder.setView(dialogView)

            .setPositiveButton("Figurar" , new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                        verificar(dialogView);
                        finish();
                }
            })
            .setNegativeButton("No figurar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(MainActivity.this,Ranking.class);
                    startActivity(intent);
                }
            });

    builder.show();


}