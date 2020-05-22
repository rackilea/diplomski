try {
   //do some work
}  
catch ( RecoverableException1 re1) {
   //cleanup
}
catch ( RecoverableException2 re2) {
   //cleanup
}

finally {
   //check of state and do clean up. You would have reached here via multiple branches.
}