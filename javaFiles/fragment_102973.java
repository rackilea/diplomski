library(parallel)
cl <- makeCluster(detectCores())
parallel::parLapply(cl, 1:5, function(x) {
  rJava::.jinit()
  rJava::.jnew(class = "java/lang/Integer", x)$toString()
})