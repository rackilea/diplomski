RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
StringReader reader = new StringReader(bufferForYourTemplate);
Template template = new Template();
template.setRuntimeServices(runtimeServices);

/*
 * The following line works for Velocity version up to 1.7
 * For version 2, replace "Template name" with the variable, template
 */
template.setData(runtimeServices.parse(reader, "Template name")));

template.initDocument();