// using ClassPathResource, you can also use a FileResource or other method to load config
Resource  res = new ClassPathResource("/beans.xml");
// initialize bean factory
BeanFactory  factory = new XmlBeanFactory(res);        

// retrieve Spring managed Action class
ActionListener action = factory.getBean("usergui", ActionListener.class);

// configure login button
loginButton.addActionListener(action);