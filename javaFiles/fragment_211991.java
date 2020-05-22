@NoAutoStart
public class StartupSizeTimeBasedTriggeringPolicy<E> extends SizeAndTimeBasedFNATP<E> {

    private boolean started = false;

    @Override
    public boolean isTriggeringEvent( File activeFile, E event ) {
        if ( !started ) {
            nextCheck = 0L;
            return started = true;
        }

        return super.isTriggeringEvent( activeFile, event );
    };
}