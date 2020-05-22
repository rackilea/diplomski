String url = "https://spreadsheets.google.com/formResponse?formkey="+ YOUR_KEY+
                         "&entry.0.single="+URLEncoder.encode(val1)+
                         "&entry.1.single="+URLEncoder.encode(val2)+
                         "&entry.2.single="+URLEncoder.encode(val3)+
                         "&entry.3.single="+URLEncoder.encode(val4);
myReq.sendPost(url, "");