private static CountDownTimer createTimer( int aLimit, int aInterval )
{
    return new CountDownTimer( aLimit, aInterval, context )
    {
        @Override
        public void onTick( long millisUntilFinished )
        {
            Toast.makeText( context .getApplicationContext(), "50 Seconds until power off", Toast.LENGTH_LONG ).show();
        }

        @Override
        public void onFinish()
        {
            powerOff();

        }
    };
}