@Override
protected void onDraw( Canvas canvas )
{
    super.onDraw( canvas );

    // Return if we have no movie
    if( mMovie == null ) return;

    // Catch the time now
    long now = System.currentTimeMillis();

    // Catch the start time if needed
    if( mStartTime == 0 ) mStartTime = now;

    int relTime = (int)( (now- mStartTime) % mMovie.duration() );
    mMovie.setTime( relTime );
    mMovie.draw( canvas, mDrawLeftPos, this.getPaddingTop() );
}