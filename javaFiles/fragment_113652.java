if (cached json file exists) {
  if (json file last modified + 1 day > current time) {
    json = get from network;
    cache json in file;
  } else [
    json = get from file;
  }
} else {
    json = get from network;
    cache json in file;
}