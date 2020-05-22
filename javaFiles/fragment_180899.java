if(count > 0) {
  change = Math.abs(temp - temp2);
  UI.println(change);
  if( change > bigChange ) {
    bigChange = change;
  }
}