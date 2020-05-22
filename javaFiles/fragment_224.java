private ViewFactory viewFactory = new ViewFactory() {
        public View makeView()  {
            LayoutInflater inflater = LayoutInflater.from(TextSwitcherTest.this);
            TextView textView = (TextView) inflater.inflate(R.layout.textView, null);
            return textView;
        }
};