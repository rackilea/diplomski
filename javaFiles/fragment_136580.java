HashMap<String, Object>[] filesArr =
  uploadedVideoItemObj.getPreviewImagesURLsList().parallel()
  // or better if getPreviewImagesURLsList() was returning a List:
  // uploadedVideoItemObj.getPreviewImagesURLsList().parallelStream()
  .map(fileName -> {
    HashMap<String, Object> m = new HashMap<>();
    m.put("preview_file", fileName);
    m.put("parent_id", gotId);
    return m;
  }).toArray(HashMap[]::new);