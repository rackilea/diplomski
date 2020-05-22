pv.message.setClickable(true);
pv.message.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Toast.makeText(arg0.getContext(), "sample", Toast.LENGTH_SHORT).show();
        }
    });