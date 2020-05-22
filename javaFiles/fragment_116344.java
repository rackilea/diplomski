Button downloadBtn = new Button("Download File");
    downloadBtn.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            Window.open("http://urlforfiledownload", "download", "");
        }
    });