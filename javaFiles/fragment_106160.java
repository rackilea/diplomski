for(MyStreamBound mmib: mmiList){
         CharBuffer buffer = CharBuffer.wrap(rslt.toString());
         mmib.myoutbound.writeTextMessage(buffer);
         mmib.myoutbound.flush();

     }