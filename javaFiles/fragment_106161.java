for(int i = 0; i < mmiList.size(); i++) {
         MyStreamBound mmib = mmiList.get(i);
         CharBuffer buffer = CharBuffer.wrap(rslt.toString());
         mmib.myoutbound.writeTextMessage(buffer);
         mmib.myoutbound.flush();

     }