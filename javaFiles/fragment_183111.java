FooServiceLocator fooLocator = new FooServiceLocator();
fooLocator.getEngine().setOption("sendMultiRefs", false);
Foo foo = fooLocator.getFooService(new URL(soapServiceUrl));

FooStub binding = (FooStub) foo;
binding.setTimeout(soapTimeoutSecs * 1000);