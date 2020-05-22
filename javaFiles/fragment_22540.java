Optional.ofNullable(listEvidence).ifPresent((eviList -> {
  // your logic
  try {
    evidenceDetailDAO.updateIsSelectedFlag(repoKeysList, 0,configurationService.getNodeName());
  } catch (Exception e) {
    throw new RuntimeException(e);
  }
});