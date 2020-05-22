router.route("/entity/:parent_id/sub-entity/:child_id", ctx -> {
  String parentEntityId = r.request().getParameter("parent_id");
  Entity parent = Entities.get(parentEntityId);
  String myid = r.request().getParameter("child_id");
  Part myself = parent.getPart(myid);
  // do something with myself
});