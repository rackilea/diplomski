package com.example;

    import java.util.Map;

    import org.apache.camel.Body;
    import org.apache.camel.Exchange;
    import org.apache.camel.Handler;
    import org.apache.camel.Headers;
    import org.apache.camel.Message;

    public class GeneralProcessor {
        @Handler

        public void PrepapreErrorImportReport
        (

                @Headers Map hdr
                , Exchange exch
        )
        {

            //todo: Get the message as a string;

            Message in = exch.getIn();
            String msg = (String)in.getBody();
            // Now check if body contains failed or ok.
            if(msg.contains("OK")){
                //todo: go party the message was OK
            }
            else{
               //todo: Oh Oh! Houston we have a problem
            }


        }

    }