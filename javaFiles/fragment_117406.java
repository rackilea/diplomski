public bool canReadFile(path) {
  if (!fileExists(path))  
    return false;

  if (!fileIsReadable(file))
    return false;

  ...
  return true;
}