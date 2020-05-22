private static void initStatus(Status s) {
  s.setStatus(JobStatus.UNINITIATED);
  s.setLastAccessedTime(0);
  s.setOffSet(null);
  s.setStreamNo(null);
}

Set<Status> statusClone = cloner.deepClone(statusList).stream()
                  .filter(s -> !(s instanceof FileMetadata))
                  .peek(MyClass::initStatus)
                  .collect(Collectors.toSet());