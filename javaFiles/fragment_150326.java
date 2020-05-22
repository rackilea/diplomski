vals.foreach { v =>
  df.filter($"dt_geo_cat_brand" === v)
    .select(split($"userId", "\\|").as("userId"))
    .write
    .csv(s"$baseOutputBucketPath=$v/")})
}