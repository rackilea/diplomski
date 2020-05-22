String[] webContents = new String[] { "mysite.com/myimage.png",
        "mysite.com/1234/12/12/myimage.png" };

for (String webContent : webContents) {
    String text = webContent.replaceAll("mysite\\.com/(\\d{4}/\\d{2}/\\d{2}/)?",
            String.valueOf("mysite.com/abc/"));
    System.out.println(text);
}