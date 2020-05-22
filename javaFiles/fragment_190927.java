while (i<=m.groupCount())
       {
           System.out.println("group" + i + m.group(i));
           System.out.println("starting index:" + m.start(i) + "Ending Index:" + m.end(i));
           i++;
       }