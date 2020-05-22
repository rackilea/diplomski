btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    
                if(selectedView!=null){                        
                    String companyId = ((TextView) selectedView.findViewById(R.id.spinnerItemIdTv)).getText().toString();
                }
               else{//Something}    

            }
        });