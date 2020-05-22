MIMEEntity emailRootChild = emailRoot.createChildEntity();
                        if (null != emailRootChild) {
                            final String boundary = System.currentTimeMillis() + "-" + "ABC";
                            emailHeader = emailRootChild.createHeader("Content-Type");
                            emailHeader.setHeaderVal("multipart/alternative; boundary=\"" + boundary + "\"");

                            MIMEEntity emailChild = emailRootChild.createChildEntity();
                            if (null != emailChild) {

                                Stream stream = session.createStream();                             

                                emailChild = emailRootChild.createChildEntity();
                                stream = session.createStream();
                                stream.writeText(this.getHTML());
                                emailChild.setContentFromText(stream, "text/html; charset=\"UTF-8\"", MIMEEntity.ENC_NONE);
                                stream.close();
                                stream.recycle();
                                stream = null;
                            }                   
                        }