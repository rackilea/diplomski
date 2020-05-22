MyBean bean = new MyBean(); //This should be your bean
Object o1 = bean.getObject1(); //Please don't use Object, use the correct type
Object o2 = bean.getObject2();

request.setAttribute("name",o1); //name can be anything you want
request.setAttribute("test",o2);
//forward to JSP