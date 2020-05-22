RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(baseUrl)
                .build();

        ArticleGetListService articleGetListService = restAdapter.create(ArticleGetListService.class);
        Callback<ArticleViewPojo> callback = new Callback<ArticleViewPojo>() {
            @Override
            public void success(ArticleViewPojo model, Response response) {
                //use model which is data returned to you
            }
            @Override
            public void failure(RetrofitError error) {
                //handle error
            }
        };
        //START REST CALL
        articleGetListService.getArticleList(languageCode, categoryId, token, callback);
       //above parameters are those written in service interface at 1

//Whole Url is baseUrl+ArticleGetListService in above example