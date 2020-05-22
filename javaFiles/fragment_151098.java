// 1. convert your string date to LocalDate
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 LocalDate localDate = LocalDate.fromMillisSinceEpoch(sdf.parse("2006-06-08").getTime());

 // 2. then pass it to your query
 Statement statement = QueryBuilder.select()
   .all()
   .from(keySpaceName, tableName)                      
   .where((QueryBuilder.eq("asset", categoryPos)))
   .and(QueryBuilder.gte("date", localDate)
   .limit(10)
   .allowFiltering()
   .enableTracing();