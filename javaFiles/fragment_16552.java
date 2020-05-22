Resources res = getResources(); // Resource object to get Drawables   
tabHost = getTabHost();  // The activity TabHost  
TabHost.TabSpec spec;  // Resusable TabSpec for each tab    
Intent intent;  // Reusable Intent for each tab   

intent = new Intent().setClass(this, First.class);      
spec = tabHost.newTabSpec("First Tab").setIndicator("First Tab",res.getDrawable(R.drawable.icon)).setContent(intent); 
tabHost.addTab(spec);   

intent = new Intent().setClass(this, Second.class); 
spec = tabHost.newTabSpec("Second Tab").setIndicator("Second Tab",res.getDrawable(R.drawable.icon)).setContent(intent); 
tabHost.addTab(spec); 

tabHost.setCurrentTab(1);