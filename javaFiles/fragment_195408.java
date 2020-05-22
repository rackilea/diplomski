doc = (HTMLDocument) myPane.getDocument();
    StringBuilder sb = new StringBuilder();
    javax.swing.text.Element[] styles = doc.getRootElements();
    for (int i = 0; i < styles.length; i++) {
        int size = styles[i].getElementCount();
        if (!styles[i].getName().contains("bidi root")) {
            //   System.out.println("<"+styles[i].getName()+">");
            //  sb.append("<"+styles[i].getName()+">");
        }
        for (int j = 0; j < size; j++) {
            String element = styles[i].getElement(j).getName();
            if (element.equals("body")) {
                int subsize = styles[i].getElement(j).getElementCount();
                for (int k = 0; k < subsize; k++) {
                    element = styles[i].getElement(j).getElement(k).getName();
                    if (element.equals("p-implied")) {
                        int subsubsize = styles[i].getElement(j).getElement(k).getElementCount();
                        String cond = "fail", boldc = "</b>", boldi = "</i>";
                        for (int l = 0; l < subsubsize; l++) {
                            javax.swing.text.Element elem = styles[i].getElement(j).getElement(k).getElement(l);
                            element = elem.getName();
                            if (!element.contains("content")) {
                                //    System.out.println("<"+element+">");
                                sb.append("<" + element + ">");
                            }
                            if (element.equals("content")) {
                                AttributeSet attributes = elem.getAttributes();
                                Enumeration attrs = attributes.getAttributeNames();
                                while (attrs.hasMoreElements()) {
                                    String rft = attrs.nextElement().toString();
                                    if (rft.equals("b")) {
                                        //  System.out.println("<"+rft+">");
                                        sb.append("<" + rft + ">");
                                        cond = "passb";
                                    } else if (rft.equals("i")) {
                                        sb.append("<" + rft + ">");
                                        cond = "passi";
                                    }
                                }
                            }
                            try {
                                //      System.out.println( elem.getDocument().getText(elem.getStartOffset(), (elem.getEndOffset() - elem.getStartOffset())));
                                sb.append(elem.getDocument().getText(elem.getStartOffset(), (elem.getEndOffset() - elem.getStartOffset())));
                            } catch (BadLocationException ex) {
                                Logger.getLogger(GridEditor.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            if (cond.equals("passi")) {
                                //    System.out.println( boldi);
                                sb.append(boldi);
                            }
                            if (cond.equals("passb")) {
                                // System.out.println( boldc);
                                sb.append(boldc);
                            }

                            cond = "fail";

                        }
                    }
                }
            }


        }

    }

    String text = sb.toString();
    System.out.println("final string --> "+text);