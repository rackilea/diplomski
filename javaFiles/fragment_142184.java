button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            taps = taps + 1;
            tapCount.setText(start + taps);
        }
});