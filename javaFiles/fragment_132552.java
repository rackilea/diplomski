Elements lessondata = td.select(
                      " > table.container > tbody > tr > td > span.nobr");
if (!lessondata.isEmpty()) {
  for (Element lesson : lessondata) {
    System.out.println("Lesson...");
  }
}