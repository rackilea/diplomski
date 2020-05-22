Runnable r = new Runnable () {
    @Override
    public void run() {
        PlayActivity self = PlayActivity.this;
        self.textViews[self.textViewToUpdate].setText(Integer.toString(self.counter));
        self.textViewToUpdate++;
        if (self.textViewToUpdate == self.textViews.length) {
            self.textViewToUpdate = 0;
            self.counter++;
            if (self.counter == 8) {
                self.t.stopTimer();
            }
        }
    }
}