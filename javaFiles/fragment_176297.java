public void onViewCreated(View view, ...) {

    View btn = view.findViewById(R.id.button1);
    btn.setOnClickListener(new View.OnClickLisener() {

        public void onClick(View view) {
            Log.d("My App", "The button was clicked");
        }

    }

}