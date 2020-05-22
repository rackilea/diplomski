String[] additionalInformation = tox.getAdditionalInformation().split("\n");

for(String s : additionalInformation) {
  String[] part = s.split(":");
  if("Element Info".equals(part[0]) {
    String elementInfo = part[...]; //you need to investigate the right output of the split
  }
}