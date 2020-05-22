String HTML_REGEX = "<.+?>";
String yourHTML = "<html><body><h1>Lorem Ipsum</h1>" + 
                  "<p>Lorem <i>Ipsum</i> dolorem sedet. Set nihil amat. " + 
                  "<sub>I don't know the text</sub></p></body></html>"

String content = yourHTML.replaceAll(HTML_REGEX, "\n");
System.out.println(content);