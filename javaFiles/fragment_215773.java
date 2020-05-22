binder.registerCustomEditor(Custom.class,
        new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) {
                Custom custom = dao.find(Custom.class,
                        Integer.parseInt(text));
                setValue(Custom);
            }
        });