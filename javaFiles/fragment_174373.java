PostUpdate post = new PostUpdate(new URL("http://priklad.sk"))
                .picture(new URL("http://priklad.sk/obrazcok/testik.png"))
                .name("priklad")
                .caption("priklad")
                .message("priklad")
                .description("priklad");
try {
     if (pageToken != null) {
         facebook.setOAuthAccessToken(new AccessToken(id));
         facebook.postFeed(post);
         Input.addInfoAnnotation(req, "sysAdminTools.annotation.fb.ok");
                            }
      } catch (FacebookException ex) {
         Logger.getLogger(EditAdPreviewServlet.class.getName()).log(Level.SEVERE, null, ex);
      }