TabListenerImpl listener = new TabListenerImpl(this);
Tab tab = actionBar.newTab().setText("TAB1").setTag("TAB1").setTabListener(listener);
listener.addTab("TAB1", Tab1Class.class);
actionBar.addTab(tab);

tab = actionBar.newTab().setText("TAB2").setTag("TAB2").setTabListener(listener);
listener.addTab("TAB2", Tab2Class.class);
actionBar.addTab(tab);