try {
    grammarPath = new File("\\Path\\To\\grammar\\").toURI().toURL().toString();
} catch (Exception e) {
    help.setText("" + e);
}
 voce.SpeechInterface.init("./lib", true, true, grammarPath, "digits");