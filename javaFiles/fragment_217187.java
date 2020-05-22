final LinearLayout layout = new LinearLayout(this);
    ScrollView scrollView = new ScrollView(this);
    layout.setOrientation(LinearLayout.VERTICAL);
     CheckBox[] t=new CheckBox[15];
     for (i=0;i<currentBattery.temperatureNumber;i++)
     {               
         t[i]=new CheckBox(this);
         t[i].setText("title");
         t[i].setChecked(false);
         t[i].setOnCheckedChangeListener(this);

         scrollView.addView(t[i]);      
     }