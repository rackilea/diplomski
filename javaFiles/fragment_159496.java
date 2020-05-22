TermBean bean1=new TermBean("JSON");
TermBean bean2=new TermBean("simple");
ArrayList list=new ArrayList();
        list.add(bean1);
        list.add(bean2);
BaseBean bb=new BaseBean();
        bb.setXId(11);
        bb.setPNRNumber("123456789");
        bb.setMinPriced(list);

ObjectMapper mapper = new ObjectMapper();
Module myModule = new MyModule();
mapper.registerModule(myModule);        
String jsonInString = mapper.writeValueAsString(bb);      
System.out.printf( "JSON: %s", jsonInString );