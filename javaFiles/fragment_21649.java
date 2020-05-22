private static Status cloneAndInitStatus(Status s) {
  Status clone = new Status(s);
  clone.setStatus(JobStatus.UNINITIATED);
  clone.setLastAccessedTime(0);
  clone.setOffSet(null);
  clone.setStreamNo(null);
  return clone;
}

Set<Status> statusClone = statusList.stream()
                  .filter(s -> !(s instanceof FileMetadata))
                  .map(MyClass::cloneAndInitStatus)
                  .collect(Collectors.toSet());