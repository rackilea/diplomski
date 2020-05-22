button.setOnClickListener(new OnClickListener() {

    @Override
        public void onClick(View v) {
            getUrlText();
            handler.post(timedTask);
        }
    });