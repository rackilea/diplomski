new findCar(new OnCarListener()
    {
        @Override
        public void onCarCompleted(String c)
        {
            // Do your work
        }

        @Override
        public void onCarError(String error)
        {
            // Do your work
        }   
    }).execute();