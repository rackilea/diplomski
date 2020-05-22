Define myHTable
setup() {
  Instantiate myHtable
  Disable myHtable autoflush to prevent puts from being automatically flushed
  Set myHtable write buffer to at least 2MB
}
reduce(rowkey, results) {
  baseTimestamp = current time in milliseconds
  Iterate results {
     Instantiate put with rowkey ++baseTimestamp
     Add result to put
     Send put to myHTable
  }
}
cleanup() {
  Flush commits for myHTable
  Close myHTable
}