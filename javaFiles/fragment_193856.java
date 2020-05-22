public void goToHighScore(View view) {
    Intent intent = new Intent(this, DisplayScoreActivity.class);
    Fragment currentFragment = mSectionsPagerAdapter.getItem(mViewPager.getCurrentItem());
    String highScore = currentFragment.getScore();
    intent.putExtra(HIGH_SCORE, highScore);
    startActivity(intent);
}