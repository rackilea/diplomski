MySQLBooleanPrefJDBCDataModel jdbc = new MySQLBooleanPrefJDBCDataModel(dataSource, TABLE_NAME, USER_ID, ITEM_ID);
CachingRecommender cachingRecommender = new CachingRecommender( new SlopeOneRecommender(jdbc));

// Get 5 recommendations for user 3
 List<RecommendedItem> items = cachingRecommender.recommend(3, 5);
  for (RecommendedItem item : items) {
        System.out.println(item);
  }