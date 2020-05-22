fab.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            i.putExtra("next", "Leg Curls X 20");
            startActivity(i);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();

        }
    });