String serializeToJson(Person person) 
{
    // Retrieve the AutoBean controller
    AutoBean<Person> bean = AutoBeanUtils.getAutoBean(person);
    return AutoBeanCodex.encode(bean).getPayload();
}

Person deserializeFromJson(String json) 
{     
    AutoBean<Person> bean = AutoBeanCodex.decode(myFactory, Person.class, json);     
    return bean.as();   
}