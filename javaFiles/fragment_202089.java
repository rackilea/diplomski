Robot rb = new Robot();

StringSelection textToPaste= new StringSelection("  ");//make sure u enter tab here

Toolkit.getDefaultToolkit().getSystemClipboard().setContents(textToPaste, null);

rb.keyPress(KeyEvent.VK_CONTROL);    
rb.keyPress(KeyEvent.VK_V);    
rb.keyRelease(KeyEvent.VK_V);    
rb.keyRelease(KeyEvent.VK_CONTROL);