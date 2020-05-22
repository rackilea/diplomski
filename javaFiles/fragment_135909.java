getCaseNumber(new Callback() {
        @Override
        public void firebaseResponseCallback(String result) {
            here, this result parameter that comes through is your api call result to use, so result will be your case number, so make your objects inside this method, not outside
        }
    });
}