try {
    Process p = Runtime.getRuntime().exec("\"/Program Files (x86)/Google/Chrome/Application/chrome.exe\"");
    p.waitFor();
    System.out.println("Google Chrome launched!");
} catch (Exception e) {
    e.printStackTrace();
}