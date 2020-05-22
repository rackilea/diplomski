try {
                    File f =im.file;
                    icon =(ImageIcon) label.getIcon();
             String filename= f.toURI().toString();  
                    int w =icon.getIconWidth();
int h =icon.getIconHeight();

                    MutableAttributeSet attr = new SimpleAttributeSet();
attr.addAttribute(StyleConstants.NameAttribute,HTML.Tag.IMG);
attr.addAttribute(HTML.Attribute.SRC, filename);
attr.addAttribute(HTML.Attribute.HEIGHT,
Integer.toString(h));
attr.addAttribute(HTML.Attribute.WIDTH,
Integer.toString(w));
int p = editor.getCaretPosition();
doc.insertString(p, " ", attr);
 doc.insertString(editor.getCaretPosition(), "\r\n", editor.getCharacterAttributes());







                } catch (Exception ex) {
                    }

        }