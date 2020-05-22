import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class BrowserTest 
{
    private static Browser browser;

    public static void main(String [] args) 
    {
        Display display = new Display();
        final Shell shell = new Shell(display);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 3;
        shell.setLayout(gridLayout);

        createBrowser(shell);

        browser.addProgressListener(new ProgressListener() 
        {
            public void changed(ProgressEvent event) {
            }
            public void completed(ProgressEvent event) {
                changeSomething();
            }
        });

        shell.open();
        browser.setUrl("http://google.com");

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    protected static void changeSomething() 
    {
        String s = "var allLinks = document.getElementsByTagName('a'); " +
                "for (var i=0, il=allLinks.length; i<il; i++) { " +
                    "elm = allLinks[i]; elm.style.border = 'thin solid red';" +
                "}";

        System.out.println(browser.execute(s));
    }

    private static void createBrowser(Shell shell) 
    {
        ToolBar toolbar = new ToolBar(shell, SWT.NONE);
        ToolItem itemGo = new ToolItem(toolbar, SWT.PUSH);
        itemGo.setText("Go");

        GridData data = new GridData();
        data.horizontalSpan = 3;
        toolbar.setLayoutData(data);

        Label labelAddress = new Label(shell, SWT.NONE);
        labelAddress.setText("Address");

        final Text location = new Text(shell, SWT.BORDER);
        data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.horizontalSpan = 2;
        data.grabExcessHorizontalSpace = true;
        location.setLayoutData(data);

        try {
            browser = new Browser(shell, SWT.NONE);
        } catch (SWTError e) {
            System.out.println("Could not instantiate Browser: " + e.getMessage());
            //display.dispose();
            return;
        }
        data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.horizontalSpan = 3;
        browser.setLayoutData(data);

        /* event handling */
        Listener listener = new Listener() 
        {
            public void handleEvent(Event event) 
            {
                ToolItem item = (ToolItem)event.widget;
                String string = item.getText();
                if (string.equals("Go")) browser.setUrl(location.getText());
            }
        };

        browser.addLocationListener(new LocationListener() {
            public void changed(LocationEvent event) {
                if (event.top) location.setText(event.location);
            }
            public void changing(LocationEvent event) {
            }
        });


        itemGo.addListener(SWT.Selection, listener);
        location.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                browser.setUrl(location.getText());
            }
        });     
    }
}