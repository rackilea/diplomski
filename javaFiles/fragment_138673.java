button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            String s = (String) v.getTag();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, s, duration);
            toast.show();

        }
    });