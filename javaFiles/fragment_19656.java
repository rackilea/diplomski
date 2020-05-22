library(rJava)
.jinit()
# create a hash map
hm<-.jnew("java/util/HashMap")
# using jrcall instead of jcall, since jrcall uses reflection to get types 
.jrcall(hm,"put","one", "1")
.jrcall(hm,"put","two","2")
.jrcall(hm,"put","three", "3")

# convert to R list
keySet<-.jrcall(hm,"keySet")
an_iter<-.jrcall(keySet,"iterator")
aList <- list()
while(.jrcall(an_iter,"hasNext")){
  key <- .jrcall(an_iter,"next");
  aList[[key]] <- .jrcall(hm,"get",key)
}