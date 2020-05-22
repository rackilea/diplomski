@Override
public void onIndexFragmentInteraction(final IndexesRecyclerViewAdapter.ViewHolder viewHolder) {

    final Context thisContext = this;
    YoYo.with(Techniques.Pulse).onEnd(new YoYo.AnimatorCallback() {
        @Override
        public void call(Animator animator) {
            CelebritiesFragment celebritiesFragment = new CelebritiesFragment();
            celebritiesFragment.setIndex(viewHolder.index);
            CelebritiesTabViewsStack.getInstance().push(celebritiesFragment);
            Intent intent = new Intent(thisContext, MainActivity.class);
            //finish();
            startActivity(intent);
            overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
        }
    }).delay(0).duration(250).playOn(viewHolder.mView);
}

@Override
public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(0, R.animator.slide_out_right);
}