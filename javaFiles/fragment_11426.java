SimpleForm form = new SimpleForm();

Map<String, Object> parameters = request.getParams();
for (Map.Entry<String, Object> entry : parameters.entrySet()) {
    BeanUtils.setProperty(form, entry.getKey(), entry.getValue());
}