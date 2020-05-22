OfficeManager officeManager = new DefaultOfficeManagerConfiguration().setOfficeHome(new File("<path to office home>")).buildOfficeManager();
officeManager.start();

OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
converter.convert(new File("test.odt"), new File("test.doc"));

officeManager.stop();