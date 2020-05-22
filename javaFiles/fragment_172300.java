@Override
protected void onResume(){
super.onResume();
arrayOfRingcatItem = new ArrayList<ItemStoryList>();
    //imageLoader = new ImageLoader(ActivityDetailStory.this);

    if (JsonUtils.isNetworkAvailable(ActivityDetailStory.this)) {
        new MyTask().execute(Constant.SERVER_URL + "/api.php?nid=" + Constant.NEWS_ITEMID);
        MyApplication.getInstance().trackScreenView("Lendo de cara : " + (Constant.CATEGORY_TITLE));
    }

    else {
        Toast.makeText(getApplicationContext(), "Problema com sua Rede de Internet", Toast.LENGTH_SHORT).show();
    }
}