public final class ProxyExample {
    public interface CommonInterfaceForProxyAndRealClasses {
        String allowedMethodGetName();
    }

    private static final class RealClass implements CommonInterfaceForProxyAndRealClasses {

        private String name;
        private String name2;

        RealClass() {
            // TODO Auto-generated constructor stub
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(final String name2) {
            this.name2 = name2;
        }

        @Override
        public String allowedMethodGetName() {
            // TODO Auto-generated method stub
            return getName() + getName2();
        }
    }

    private static final class ProxyForRealClasses
            implements CommonInterfaceForProxyAndRealClasses {
        private final CommonInterfaceForProxyAndRealClasses target;
        public ProxyForRealClasses(CommonInterfaceForProxyAndRealClasses target) {
            this.target = target;
        }
        @Override
        public String allowedMethodGetName() {
            return target.allowedMethodGetName();
        }
    }

    public static CommonInterfaceForProxyAndRealClasses getProxiedObjectWithName(String name1, String name2) {
        RealClass realClass = new RealClass();
        realClass.setName(name1);
        realClass.setName2(name2);
        return new ProxyForRealClasses(realClass);
    }
}