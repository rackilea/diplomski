Iterator<String> jobIterator = job.iterator();
while (jobIterator.hasNext()) {
  String job = jobIterator.next();
  // ... stuff ...
  jobIterator.remove(); // remove the last object that was returned by next()
}