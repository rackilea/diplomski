Factory notificationFactory = new Factory() {
       public Object create() {
            SomeTO rtVl = new SomeTO();
            return rtVl;
        }
 };
myFormBacking.setSomeTOs(LazyList.decorate(myFormBacking.getSomeTOs));