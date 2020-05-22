...
private List<StatusWrapper> statuses;
...
(getters setters)
...
public StatusBean() {
...
initStatuses();
}
...
public void initStatuses() {
  statuses=new ArrayList<>();
  List<Status> stats=getStatusList();
  for(Status status:stats) {
    StatusWrapper wrapper=new StatusWrapper();
    wraper.setStatus(status);
    wraper.setComments(commentList(status.getStatusId()));
    statuses.add(wrapper);
}