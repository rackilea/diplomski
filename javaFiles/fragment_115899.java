mHandler = new Handler() { 
              @Override public void handleMessage(Message msg) { 
                 String mString=(String)msg.obj;
                 Toast.makeText(this, mString, Toast.LENGTH_SHORT).show();
              }
          };