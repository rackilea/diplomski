@Override
protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Long userID = CTConversionUtils.convertToLong(request.getParameter("id"));
        model = (Map<String, Object>) super.filterModel(model);

        Class<?> viewClass = SecureViews.Public.class;

        if(SecurityUtils.getSubject().isAuthenticated()) {
            viewClass = SecureViews.Authenticated.class;
        }

        for (Entry<String, Object> modelEntry : model.entrySet()) {
            if (modelEntry.getValue() instanceof SecurePropertyInterface) {
                viewClass = ((SecurePropertyInterface)modelEntry.getValue()).getMaxPermissionLevel(userID);
            }
        }
        objectMapper.viewWriter(viewClass).writeValue(getJsonGenerator(response), model);
    }