public class TextWithButtonExample {

    /**
     * Simple class to accomplish what you want by wrapping
     * the Text and Label objects with a Composite.
     */
    public class TextWithButton {

        public TextWithButton(final Composite parent) {
            // The border gives the appearance of a single component
            final Composite baseComposite = new Composite(parent, SWT.BORDER);
            baseComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
            final GridLayout baseCompositeGridLayout = new GridLayout(2, false);
            baseCompositeGridLayout.marginHeight = 0;
            baseCompositeGridLayout.marginWidth = 0;
            baseComposite.setLayout(baseCompositeGridLayout);

            // You can set the background color and force it on 
            // the children (the Text and Label objects) to add 
            // to the illusion of a single component
            baseComposite.setBackground(new Color(parent.getDisplay(), new RGB(255, 255, 255)));
            baseComposite.setBackgroundMode(SWT.INHERIT_FORCE);

            final Text text = new Text(baseComposite, SWT.SINGLE);
            text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

            // Get whatever image you want from wherever
            // (in this case the web so it can be run easily!)
            Image buttonImage;
            try {
                buttonImage = ImageDescriptor.createFromURL(new URL("http://eclipse-icons.i24.cc/ovr16/clear.gif")).createImage();
            } catch (final MalformedURLException e) {
                buttonImage = null;
            }

            final Label button = new Label(baseComposite, SWT.NONE);
            button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
            button.setImage(buttonImage);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseUp(final MouseEvent e) {
                    // Do whatever you want when the 'button' is clicked
                    text.setText("");
                }
            });
        }

    }

    final Display display;
    final Shell shell;

    public TextWithButtonExample() {
        display = new Display();
        shell = new Shell(display);
        shell.setLayout(new GridLayout());
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new TextWithButton(shell);
    }

    public void run() {
        shell.setSize(200, 100);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    public static void main(final String[] args) {
        new TextWithButtonExample().run();
    }

}