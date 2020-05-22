if (qName.equalsIgnoreCase("Level")) {
     lessonEasyInfo.setLevel(currentValue.trim());
     List.add(lessonEasyInfo);
 }
 else if (qName.equalsIgnoreCase("Name"))
     lessonEasyInfo.setName(currentValue.trim());
 else if (qName.equalsIgnoreCase("LinkFile"))
     lessonEasyInfo.setLinkFile(currentValue.trim());
 else if (qName.equalsIgnoreCase("Script"))
     lessonEasyInfo.setScript(currentValue.trim());