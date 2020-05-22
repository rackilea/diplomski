void game_over() {
    if (isSignedIn) {
        num_lifes = 0;
        findViewById(R.id.hero).setEnabled(false);
        findViewById(R.id.btn_play).setVisibility(View.GONE);
        show_lifes();
        Games.getLeaderboardsClient(this, GoogleSignIn.getLastSignedInAccount(this))
            .submitScore(getString(R.string.leaderboard_id), score);

        findViewById(R.id.game_over).setVisibility(View.VISIBLE);
    }
}