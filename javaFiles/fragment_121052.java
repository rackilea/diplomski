URLConnection url_conn = url.openConnection();
httpURLConnection http_url_conn = (httpURLConnection )url.openConnection();

String contentType = http_url_conn.getContentType()

  if(contentType.contains("text/plain")){
    //handle plain text
    .....
  } else if(contentType.contains("images/jpeg")){
    //handle image
    ......
  }