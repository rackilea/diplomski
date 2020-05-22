ActivityB {
  onClick() {
    MySingleton.getInstance().getContacts().add( theContact );
  }
}

ActivityA {
    onResume() {
        // consider contacts may have changed and redraw
        listViewAdapter.clear();
        listViewAdapter.addAll( MySingleton.getInstance().getContacts() );
    }    
}