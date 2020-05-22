@Override
protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    if ("some_action".equals(intent.getAction())) {
        //your action, in your case create and assign fragment

        //remove the action
        intent.setAction(null);
    }
}