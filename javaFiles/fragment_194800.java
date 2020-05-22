WindowInterceptor
    .init(new Trigger() {
        public void run() throws Exception {
            window.getComboBox("ComboBoxName").select("Choice that will cause erromessage");
        })
    .run();