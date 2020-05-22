private final Handler mHandler = new Handler() {
                boolean flag=true;
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {

                    case MESSAGE_READ:
                       if (flag) {

                           byte[] readBuf = (byte[]) msg.obj;

                           String readMessage = new String(readBuf, 0, msg.arg1);

                           //you don't need loop
                           //for(int i = 0; i<readBuf.length; i+=2) //{                                  

                              mConversationArrayAdapter.add(readMessage);

                          //}           

                        } 
                        flag = !flag;

                        break;

                    case MESSAGE_WRITE  .....

                    }
         }