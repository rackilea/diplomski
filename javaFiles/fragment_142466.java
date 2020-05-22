if (years1 > years2) {
  return 1;
} else if (years1 < years2) {
  return -1;
}
if (mm1 > mm2) {
  return 1;
} else if (mm1 < mm2) {
  return -1;
}
if (dd1 > dd2) {
  return 1;
} else if (dd1 < dd2) {
  return -1;
}
return 0;