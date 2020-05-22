dist_pk_pj = dist(pk,pj);

/* then do as you did before */
for (int k = 1; k < i; ++k) {
  tmp = l(k,i) + dist_pk_pj;
  if (tmp < min) {
    min = tmp;
  }
}