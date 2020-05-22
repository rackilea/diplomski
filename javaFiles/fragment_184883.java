ApplicationContext ctx = new ClassPathXmlApplicationContext(myCtxPath)
{
    protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader)
    {
        super.initBeanDefinitionReader(reader);
        reader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
        reader.setBeanClassLoader(getClassLoader());
    }
}