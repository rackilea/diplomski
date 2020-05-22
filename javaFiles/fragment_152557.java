@Override
        public Fragment getItem(int pos) {
            pos = pos % details.size();
            ....
        }

        @Override
        public int getCount() {
            return  99999;
        }