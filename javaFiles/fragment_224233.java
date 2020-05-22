ServiceHelper.getInstance().getAllCategory().enqueue(new Callback<List<CategoryModel>>() {
        @Override
        public void onResponse(Response<List<CategoryModel>> response, Retrofit retrofit) {
            processResponse(response);
        }

        @Override
        public void onFailure(Throwable t) {
            processResponse(null);
        }
    });