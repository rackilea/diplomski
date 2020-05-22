@Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.cab, menu);

        final MenuItem item = menu.findItem(R.id.your_share_action_provider_id);
        mshare = (ShareActionProvider) item.getActionProvider();
        mshare.setShareIntent(Share());
        return true;
    }