//Call the method using the apihelper object
     apiHelper.apiCall(Parameter parameter,new CallBackPresenter() {
        @Override
        public void success(DataModel model) {
            //update recycler view here.
        }

        @Override
        public void showError(String error) {
            //show error here.
        }

        @Override
        public void showLoader() {

        }

        @Override
        public void hideLoader() {

        }
    });