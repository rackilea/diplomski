ArrayAdapter<String> answerAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_activated_1) {
        @Override
        public View getView(int position, View convertView,
                ViewGroup parent) {
            View v =super.getView(position, convertView, parent);;
            v.setBackgroundColor(Color.RED);
            return v;
        }

    };