final Timer timer = new Timer() {

        @Override
        public void run() {
              try {
                someService.initTable(new AsyncCallback<SomeObject>() {

                     @Override
                     public void onFailure(Throwable caught) {
                     }

                     @Override
                     public void onSuccess(SomeObject result) {
                         initData(numbersTable, result);
                     }
                   });
                } catch (Exception e) {
                }
        }

};
timer.scheduleRepeating(10000);