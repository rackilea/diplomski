public void close() throws IOException
 {
     //if there is a live, unfinished exchange, set its status to be
     //excepted and wake up anyone waiting on waitForDone()

     if (_exchange != null && !_exchange.isDone())
     {
         switch (_exchange.getStatus())
         {
             case HttpExchange.STATUS_CANCELLED:
             case HttpExchange.STATUS_CANCELLING:
             case HttpExchange.STATUS_COMPLETED:
             case HttpExchange.STATUS_EXCEPTED:
             case HttpExchange.STATUS_EXPIRED:
                 break;
             default:
                 _exchange.setStatus(HttpExchange.STATUS_EXCEPTED);
                 _exchange.getEventListener().onException(new EOFException("local close"));
         }
     } 
     _endp.close();
 }