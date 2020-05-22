@Override
        public void onPause() {
     saveData();
            super.onPause();

        }

        @Override
        public void onStop() {
 saveData();
            super.onStop();

        }

        @Override
        public void onDestroy() {
    saveData();
            super.onDestroy();

        }