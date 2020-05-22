final String x[] ={""}
for(int i=0;i<checkBox_fiber_ID.length;i++){
        int temp=getResources().getIdentifier(checkBox_fiber_ID[i],"id",getPackageName());
        checkBoxes_fiber[i]=findViewById(temp);
        checkBoxes_fiber[i].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBoxes_fiber[i].isChecked()){
                   x[0]=checkBoxes_fiber[i].getvalue==> value name
                }
            }
        });
    }