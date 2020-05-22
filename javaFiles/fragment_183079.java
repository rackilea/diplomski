if (condition1) {
  specificToCondition1();
  moreCondition1Stuff();
  execCond1AndCond2Stuff();
}
else if (condition2) {
  specificToCondition2();
  moreCondition2Stuff();
  execCond1AndCond2Stuff();
}

void execCond1AndCond2Stuff() {
  commonCode();
  moreCommonCode();
}