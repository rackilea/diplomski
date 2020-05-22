vals.foreach { v =>
  df2.filter($"dt_geo_cat_brand" === v)
    .select("userId")
    .write
    .csv(s"$baseOutputBucketPath=$v/")})
}