Log log = new Log();
Needed to set ID before adding it to mAdapter
log.setmDate(date);
log.setmAmount(amount);
log.setmMiles(miles);

mDataSource.insert(date, amount, miles, OilTable.TAG);

log.setmId(mDataSource.getLastLogID(OilTable.TAG));

mAdapter.add(log);