public void createReorderModal(Component comp) {
    Map args = new HashMap();
    List list = new ArrayList();
    list.add("test");
    args.put("availableList", list );
    Executions.getCurrent().createComponents("/core/component/model_window.zul",comp, args);

        }