ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float scale =  TheCompany.screen_width / view.getWidth();
                if(view.getScaleX() == 1) {
                    view.setScaleY(scale);
                    view.setScaleX(scale);
                }else{
                    view.setScaleY(1);
                    view.setScaleX(1);
                }
            }


        });