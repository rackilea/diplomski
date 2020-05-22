// untested Java code, please debug and read documentation yourself

final List<FrameWindow> window = page.getFrames();
final HtmlPage pageTwo = (HtmlPage) window.get(0).getEnclosedPage();

// then find TinyMCE's body, which should be treated as a separated HTML page