502     if (libs != null) {
503         for (Iterator i = libs.iterator(); i.hasNext();) {
504             Object lib = i.next();
505             args.add("-libraryjars");
506             args.add(fileNameToString(lib.toString()));
507         }
508     }