listViewPlayers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Player selectedPlayer = arrayPlayers.get(position);
            ((ScoringActivity)getActivity()).showDialogFragment(selectedPlayer);
        }
});

void showDialogFragment(Player player) {
    mDialog = new ScoreAlertDialogFragment(player);
    mDialog.show(getFragmentManager(),"SCORE DIALOG");
}

public static class ScoreAlertDialogFragment extends DialogFragment {

     Player player;

     public ScoreAlertDialogFragment(Player player) {
         ..
         this.player = player;
     }


 ..
.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialog, int id) {
                    score = Integer.parseInt(editTextScore.getText().toString().trim());
                    player.setScore(score);
                }
            })