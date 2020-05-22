Log.d(TAG, "Player sprite clicked, stopping time and bringing up window...");
speedBar.setProgress(0);
infoPopUp.setTitle(player.getName());
((ImageView)infoPopUp.findViewById(R.id.infoPicture)).setImageDrawable(player.getSprite().getDrawable());
infoPopUp.findViewById(R.id.option1).setVisibility(View.INVISIBLE);
infoPopUp.findViewById(R.id.option2).setVisibility(View.INVISIBLE);
infoPopUp.findViewById(R.id.continueButton).setVisibility(View.VISIBLE);
((TextView)infoPopUp.findViewById(R.id.infoText)).setText(player.toString());
infoPopUp.show();