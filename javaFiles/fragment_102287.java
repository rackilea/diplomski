//Select a twain driver
//MorenaSource source=TwainManager.selectSource(null);
//Or select a Sane driver
MorenaSource source=SaneConnection.connect("localhost").selectSource(null);
//From this point of code, it is independent if source is twain or sane:
Image image=Toolkit.getDefaultToolkit().createImage(source);