/**
   * Convenience shorthand for {@link #addGroupIdentityLink(String, String, String)}; with type {@link IdentityLinkType#CANDIDATE}
   * 
   * @param taskId
   *          id of the task, cannot be null.
   * @param groupId
   *          id of the group to use as candidate, cannot be null.
   * @throws ActivitiObjectNotFoundException
   *           when the task or group doesn't exist.
   */
  void addCandidateGroup(String taskId, String groupId);