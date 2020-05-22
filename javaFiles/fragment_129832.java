LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        final View yourTitleView = inflater.inflate(R.layout.title, null);
        TextView yourTitle = (TextView) yourTitleView.findViewById(R.id.customTitle);
        yourTitle.setText("Your new title text");//Dynamical text
        yourTitle.setTextColor(Color.parseColor("#ffa000")); //Dynamical color

        //Your AlertDialog
        new AlertDialog.Builder(this)
                .setCustomTitle(yourTitleView) //The title's TextView's style should be the
                // same as the the one of the dialog normal AlertDialog's Title Style (see example above)
                .setView(inflater.inflate(R.layout.content, null))
                .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();