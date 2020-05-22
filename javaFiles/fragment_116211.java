package mypackage;

      import java.util.concurrent.BlockingQueue;
      import java.util.concurrent.LinkedBlockingQueue;
      import java.util.concurrent.TimeUnit;
      import org.apache.log4j.AppenderSkeleton;
      import org.apache.log4j.helpers.LogLog;
      import org.apache.log4j.spi.LoggingEvent;

      public class WebServiceAppender extends AppenderSkeleton {

            private static final BlockingQueue<LoggingEvent> loggingEventQueue = new LinkedBlockingQueue<LoggingEvent>();
            private static WebServiceAppender instance;
            private static Thread thread = null;

            //Your custom properties for your web service

            private String property1;
            private String property2;
            private String property3;

            static {
                thread = new Thread(new Runnable() {
                    public void run() {
                        processQueue();
                    }
                });

                thread.setDaemon(true);
                thread.start();
            }

            private static void processQueue() {
                while(true) {
                    try {
                        LoggingEvent event = loggingEventQueue.poll(1L, TimeUnit.SECONDS);
                        if (event != null) {
                            instance.processEvent(event);
                        }
                    }
                    catch(InterruptedException e) {
                        // No operations.
                    }
                }
            }

            private final void processEvent(LoggingEvent loggingEvent) {
                if(loggingEvent != null) {
                    //Send the loggingEvent object or you can
                    //get data out of it and package it in another
                    //java class and send that, to your web service.

                    //Web Service is invoked here
                }
            }

            public synchronized void close() {
                // The synchronized modifier avoids concurrent append and close operations

                    if(this.closed) {
                      return;
                }

                closeWS();
                thread.interrupt();

                LogLog.debug("Closing appender [" + name + "].");
                this.closed = true;
            }

            private void closeWS() {
                try {
                    //Close the webservice connection 
                    //or whatever here.
                }
                catch(Exception ex) {
                    LogLog.error("Error while closing WebServiceAppender [" + name + "].", ex);
                }
            }

            public boolean requiresLayout() {
                //Does not need a layout because
                //we are sending serialized events
                //to an external source
                return false;
            }

            @Override
            public void activateOptions() {
                instance = this;
                try {
                    LogLog.debug("Getting web service properties.");

                    if(property1 != null) {
                        //Do something with your property
                    }

                    if(property2 != null) {
                        //Do something with your property
                    }

                    if(property3 != null) {
                        //Do something with your property
                    }

                    //Initialize your web-service connection and objects here
                    LogLog.debug("Web Service created.");
                }
                catch(Exception ex) {
                    LogLog.error("Error while activating options for WebServiceAppender [" + name + "].", ex);
                }
            }

            /*
             * These methods are set from the log4j properties file like:
             * log4j.appender.WS=mypackage.WebServiceAppender
             * log4j.appender.WS.property1=bla
             * log4j.appender.WS.property2=ble
             * log4j.appender.WS.property3=blo
             */

            public final String getProperty1() {
                return property1;
            }

            public final String getProperty2() {
                return property2;
            }

            public final String getProperty3() {
                return property3;
            }

            public final void setProperty1(String property1) {
                this.property1 = property1;
            }

            public final void setProperty2(String property2) {
                this.property2 = property2;
            }

            public final void setProperty3(String property3) {
                this.property3 = property3;
            }

            @Override
            protected void append(LoggingEvent event) {
                loggingEventQueue.add(event);
            }

            @Override
            public void finalize() {
                close();
                super.finalize();
            }
      }