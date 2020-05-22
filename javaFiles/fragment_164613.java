mat <- tryCatch({
   cem(treatment = "c_CLUSTER", data = df, drop = dp))
 }, error = function(e) {
    NULL # or do something else
 }, finally = {
 })