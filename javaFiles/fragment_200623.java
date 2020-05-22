boolean firstValue = true;
for (int i=0; i < batchSize; i++) {
  inClause.append('?');
  if ( firstValue ) {
    firstValue = false;
  } else {
    inClause.append(',');
  }
}