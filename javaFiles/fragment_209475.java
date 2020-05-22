protected void randomizeTheButton(int animCount)
{
    int delay = 0;
    for(int i = 0; i < animCount; i++)
    {
        final ObjectAnimator colorAnim = ObjectAnimator.ofArgb(mButton, "backgroundColor", Color.argb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        colorAnim.setDuration(500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(0);

        mHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                colorAnim.start();
            }
        }, delay);

        delay += colorAnim.getDuration();
    }
}