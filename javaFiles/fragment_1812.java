public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    Browser browser = new Browser(shell, SWT.NONE);

    browser.addProgressListener(new ProgressListener()
    {
        @Override
        public void changed(ProgressEvent progressEvent)
        {
        }

        @Override
        public void completed(ProgressEvent progressEvent)
        {
            System.out.println(browser.evaluate("var ua = navigator.userAgent, tem, M = ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\\/))\\/?\\s*(\\d+)/i) || []; if (/trident/i.test(M[1])) { tem = /\\brv[ :]+(\\d+)/g.exec(ua) || []; return 'IE ' + (tem[1] || ''); } if (M[1] === 'Chrome') { tem = ua.match(/\\b(OPR|Edge)\\/(\\d+)/); if (tem != null) return tem.slice(1).join(' ').replace('OPR', 'Opera'); } M = M[2] ? [M[1], M[2]] : [navigator.appName, navigator.appVersion, '-?']; if ((tem = ua.match(/version\\/(\\d+)/i)) != null) M.splice(1, 1, tem[1]); return M.join(' ');"));
        }
    });
    browser.setUrl("https://www.google.co.uk");

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}