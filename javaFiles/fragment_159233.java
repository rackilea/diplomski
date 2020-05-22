TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
            tabHost.setup();
            final EditText editor = new EditText(this);
            TabSpec spec1=tabHost.newTabSpec("Tab 1");
            spec1.setContent(new TabHost.TabContentFactory(){
                 public View createTabContent(String tag){
                     return editor;
                 }
             });