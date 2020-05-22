@Override
protected Fragment createFragment() {
    UUID dreamId = (UUID)getIntent()
        .getSerializableExtra(AddFragment.EXTRA_DREAM_ID);
    mFragment = AddFragment.newInstance(dreamId);
    return mFragment;
}