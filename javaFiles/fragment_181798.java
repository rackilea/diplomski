LinearLayout rootView = 
  (LinearLayout) findViewById(R.id.mainLayout); //Or sth like this
ViewMenuButton vmb = new ViewMenuButton(this);
rootView.add(vmb);

//or if you already have it in XML
ViewMenuButton vmb = (ViewMenuButton) findViewById(R.id.myVmbtID);