JPanel main = new JPanel()
{
    @Override
    public boolean isOptimizedDrawingEnabled()
    {
        return false;
    }
};

main.setlayout( new OverlayLayout(main) );
main.add( overlayPanel );
main.add( backgroundPanel );