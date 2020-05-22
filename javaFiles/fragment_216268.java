FluentWebElement urlButton = within(secs(5)).button(By.className("btn btn-link table-text table-text ft-link"));
        urlButton.click(); //copied to clipboard
        
        
        //get copied string from clipboard
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String paste = (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
            
            //open in separate tab
             JavascriptExecutor js = (JavascriptExecutor) delegate;
            js.executeScript("popup_window = window.open('"+ paste+ "');");
            pauseFor(3000);
            js.executeScript("popup_window.close()");