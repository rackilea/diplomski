public static void main(String args[]) {
    CObject c = new CObject(); // Whatever 'c' is, obtained however it needs to be
    Document doc = new Document(); // Obtained however 'doc' needs to be
    setStuff(c, doc, 0);
  }

public void setStuff(CObject c, Document doc, int location) {

int locn = location;
try {
  switch(locn) {
    case 0:
            locn++;
            c.set(17, format(search(doc.select("div.course-info"), "h3", "Duration").select("p").first().ownText()));
    case 1:
            locn++;
            c.set(46, format(doc.select("div.course-info.l-span-7").first().select("p").first().ownText()));
    case 2:
            locn++;
            c.set(18, format(combine(search(doc.select("div.course-info.l-span-4"), "h3", "Study").select("li"))));
    case 3:
            locn++;
            c.set(52, format(doc.select("div#cs-aims-objectives").first().select("div").first().html()));
    case 4:
            locn++;
            c.set(38, format(search(doc.select("div.section-highlight"), "h3", "Professional").select("div").first().html()));
    case 5:
            locn++;
            c.set(24, format(search(doc.select("div.media-body"), "h4", "Scholarships").select("div").html()));
    default:
            return;
   }
  } catch (Exception e) {
    // do whatever with e
    setStuff(c, doc, locn);
  }
 }