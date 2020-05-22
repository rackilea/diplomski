Pattern.compile("regexp")
       .matcher(str)
       .replaceAll(mr -> {
                String.format("%s %s", 
                              mr.group(1).toUpperCase),
                              mr.group(2).indent(4);
                   });