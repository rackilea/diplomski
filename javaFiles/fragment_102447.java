File file = FileUtil.createTempFile();
    NetUtil.downloadFile("http://en.wikipedia.org/wiki/Toast", file);
    Jerry doc = Jerry.jerry(FileUtil.readString(file));
    Jerry category = doc.$("div#mw-normal-catlinks");
    category.$("ul li").each(
        new JerryFunction() {
            public boolean onNode(Jerry $this, int index) {
                System.out.println($this.text());
                return true;
            }
        });