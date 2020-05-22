public static void main(String[] args)
{
    Display display = new Display();

    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout());

    final Browser browser = new Browser(shell, SWT.NONE);
    browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final String url = "https://...";
    browser.setUrl(url);

    /* Define the function to call from JavaScript */
    new BrowserFunction(browser, "cookieCallback") {
        @Override
        public Object function(Object[] objects) {

            Object[] keyValuePairs = (Object[]) objects[0];

            for(Object keyValue : keyValuePairs)
            {
                Object[] pair = (Object[]) keyValue;

                if(Objects.equals("JSESSIONID", pair[0]))
                    System.out.println(pair[1]);
            }

            return null;
        }
    };

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Get cookie");
    button.addListener(SWT.Selection, new Listener() {
        @Override
        public void handleEvent(Event event) {
            /* Get the cookie from JavaScript and then call the function */
            browser.execute("cookieCallback(document.cookie.split( ';' ).map( function( x ) { return x.trim().split( '=' ); } ));");
        }
    });

    shell.setSize(400, 300);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }

    display.dispose();
}