public void sendInfo(View view) {
   Intent intent = new Intent(this, MatchResult.class);
   intent.putExtra(EXTRA_MESSAGE_AWAY, awaycount);
   intent.putExtra(EXTRA_MESSAGE_HOME, homecount);
   startActivituy(intent);
}