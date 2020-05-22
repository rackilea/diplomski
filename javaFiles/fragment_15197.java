public void receiveBroadcast() {
    access(()->{

        navigator.removeView(ContactBookView.NAME);
        navigator.addView(ContactBookView.NAME, new ContactBookView());
        navigator.navigateTo(ContactBookView.NAME);
        Notification.show("Grid updated", Notification.Type.TRAY_NOTIFICATION);
    });