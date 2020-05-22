private void replaceContentView(String id, Intent newIntent) {
        // TODO Auto-generated method stub
        View view = getLocalActivityManager().startActivity(id,
                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView();
        this.setContentView(view);
    }