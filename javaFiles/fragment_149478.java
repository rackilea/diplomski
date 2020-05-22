private DataSink d = null;
private Processor processor = null;

while (...) {
   if (...) {

       //interrupt transmitA
       processor.stop();
       processor.close();
       processor.deallocate();
       processor = null;
       d.close();
       d = null;
       transmitA();

       } /*else if (...) {
                   //interrupt transmitB
                   processor.stop();
                   processor.close();
                   processor.deallocate();
                   processor = null;
                   d.close();
                   d = null;
                   transmitB.stop();
                 }*/                      
        }//notation end here