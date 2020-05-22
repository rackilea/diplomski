Clipboard clipboard = Clipboard.getSystemClipboard();
ClipboardContent content = new ClipboardContent();
// for paste as image, e.g. in GIMP
content.putImage(image); // the image you want, as javafx.scene.image.Image
// for paste as file, e.g. in Windows Explorer
content.putFiles(java.util.Collections.singletonList(new File("C:\\Users\\Admin\\Desktop\\my\\mysql.gif")));
clipboard.setContent(content);