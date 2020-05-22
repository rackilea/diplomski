class TooltipHandler {
    Shell tipShell;

    public TooltipHandler( Shell parent ) {
        tipShell = new Shell( parent, SWT.TOOL | SWT.ON_TOP );

        <your components>

        tipShell.pack();
        tipShell.setVisible( false );
    }

    public void showTooltip( int x, int y ) {
        tipShell.setLocation( x, y );
        tipShell.setVisible( true );
    }

    public void hideTooltip() {
        tipShell.setVisible( false );
    }
}