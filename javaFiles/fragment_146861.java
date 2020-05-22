@Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Button button;
            if(view == null){
                button = new Button(mContext);
            }else{
                button = (Button)view;
            }

            button.setId(i);
            button.setText(String.valueOf(i));
            button.setTextSize(5);
            button.setPadding(0,0,0,0);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, view.getId()+"", Toast.LENGTH_SHORT).show();
                }

            });
            return button;
        }