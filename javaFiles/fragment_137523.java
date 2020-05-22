checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                typeProject.setVisibility(View.VISIBLE);
                project.setVisibility(View.GONE);
                ProjectName.setVisibility(View.GONE);

                // now settings the new parameters
                AbsoluteLayout.LayoutParams params = ((AbsoluteLayout.LayoutParams) typeProject.getLayoutParams());
                params.x = 100; // the new value
                params.y = 100; // the new value
                typeProject.setLayoutParams(params);
             }
            else{
                typeProject.setVisibility(View.GONE);
                project.setVisibility(View.VISIBLE);
                ProjectName.setVisibility(View.VISIBLE);

                // use the same way here with 'project' and 'ProjectName'
            }
    });