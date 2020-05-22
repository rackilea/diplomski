String url = "http://localhost:8182/test";

ClientResource cr = new ClientResource(url);
MyResource resource = cr.wrap(MyResource.class);
SomeInputBean input = new SomeInputBean();
SomeOutputBean output = resource.handleBean(input);