class Directory {
  String dirName;
  File[] files;
  String dirId;
}

class File {
  String fileName;
  String fileId;
  Revision revision;
  String creatorName;
  String disciplineName;
  String projectName;
  String directoryId
}

class Revision {
  String revisedBy;
  String imageId;
}

Directory[] directories = gson.fromJson(data, Directory[].class);