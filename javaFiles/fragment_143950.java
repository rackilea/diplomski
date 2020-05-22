textView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            new Handler().post(() -> {/*your code here*/});
        }
    }
}