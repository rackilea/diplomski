lockResource(resource);
  try {
     ... consume the resource
  } finally {
     unlockResource(resource);
  }