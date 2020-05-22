protected Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if (msg.what == SUCCESS)
            {
                setCalculatedDataToaView(); // the data you calculated from your thread can now be shown in one of your views.
            }
            else if (msg.what == FAILURE)
            {
                errorHandlerHere();//could be your toasts or any other error handling...
            }
        }
    };