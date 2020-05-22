@Command
    public void doSort(@ContextParam(ContextType.VIEW) Component view) {
        Map<String, Object> params = new HashMap<String, Object>();
            List someData = new ArrayList();
            someData.add(Add some Data which you send back);
            params.put("orderBySelection", someData);

            Binder bind = (Binder) view.getParent().getAttribute("binder");
            if (bind == null)
                return;
            bind.postCommand("doColumnSorting", params);

            view.detach();
    }