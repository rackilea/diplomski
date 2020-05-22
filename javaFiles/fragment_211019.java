void categoryAllApiCall() {


    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(base_url).build();
    final Category_All category_all = restAdapter.create(Category_All.class);
    category_all.getFeed(file, operation, all, max_depth, new Callback<CategoryPojo>() {

                @Override
                public void success(CategoryPojo categoryPojo, Response response) {
                    new Thread(new Runnable() {
                         @Override
                         public void run() {
                             Home.this.category_id = Arrays.copyOf(categoryPojo.getCategoryId(),
                            categoryPojo.getCategoryId().length);
                             Home.this.category_name = Arrays.copyOf(categoryPojo.getCategoryName(),
                            categoryPojo.getCategoryName().length);
                             Home.this.parent_id = Arrays.copyOf(categoryPojo.getParentId(),
                            categoryPojo.getParentId().length );
                             Home.this.node_depth = Arrays.copyOf(categoryPojo.getNodeDepth(),
                            categoryPojo.getNodeDepth().length);                    
                         }
                    }).run();
                }

                @Override
                public void failure(RetrofitError error) {
                    tv_title_header.setText(error.getMessage());
                }
            });
}