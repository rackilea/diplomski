outAnim.setAnimationListener( new Animation.AnimationListener()
{
    public void onAnimationEnd( Animation animation )
    {
        outView.setVisibility( View.GONE );
    }

    public void onAnimationRepeat( Animation animation )
    {
    }

    public void onAnimationStart( Animation animation )
    {
        inView.setVisibility( View.VISIBLE );
    }
} );