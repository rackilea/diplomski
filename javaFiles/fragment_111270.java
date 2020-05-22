public Hashtable parsePostData(int length, ServletInputStream instream) {
                String valArray[] = null;
                int inputLen, offset;
                byte[] postedBytes = null;
                boolean dataRemaining=true;
                String postedBody;
                Hashtable ht = new Hashtable();
                //Vector paramOrder = new Vector(10);
                StringBuffer sb = new StringBuffer();

                if (length <=0) {
                  return null;
                }
                postedBytes = new byte[length];
                try {
                   offset = 0;
                   while(dataRemaining) {
                     inputLen = instream.read (postedBytes, offset, length - offset);
                     if (inputLen <= 0) {
                       throw new IOException ("read error");
                     }
                     offset += inputLen;
                     if((length-offset) ==0) {
                       dataRemaining=false;
                     }
                   }
                } catch (IOException e) {
                  System.out.println("Exception ="+e);
                  return null;
                }

                postedBody = new String (postedBytes);
                StringTokenizer st = new StringTokenizer(postedBody, "&");

                String key=null;
                String val=null;

                while (st.hasMoreTokens()) {
                  String pair = (String)st.nextToken();
                  int pos = pair.indexOf('=');
                  if (pos == -1) {
                    throw new IllegalArgumentException();
                  }
                  try {
                     key = URLDecoder.decode(pair.substring(0, pos),"UTF8");
                     val = java.net.URLDecoder.decode(pair.substring(pos+1,pair.length()),"UTF8");
                  } catch (Exception e) {
                     throw new IllegalArgumentException();
                  }
                  if (ht.containsKey(key)) {
                    String oldVals[] = (String []) ht.get(key);
                    valArray = new String[oldVals.length + 1];
                    for (int i = 0; i < oldVals.length; i++) {
                       valArray[i] = oldVals[i];
                    }
                    valArray[oldVals.length] = val;
                  } else {
                    valArray = new String[1];
                    valArray[0] = val;
                  }
                  ht.put(key, valArray);
                  String sValues = "";
                  for(int i=0;i<valArray.length;i++) {
                      if (0<i) {
                          sValues+=",";
                      }
                      sValues = valArray[i];
                  }
                  System.out.println("Form data field " + key + ":" +sValues); 
                  //paramOrder.addElement(key);
                }
                return ht;
              }