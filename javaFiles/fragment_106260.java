import org.apache.commons.beanutils.BeanUtils;

public class Main {

    public static void main(String[] args) throws Exception {
        B source = new B();
        source.setParam("param");
        source.setParameter("parameter");
        D target = new D();
        try {
            BeanUtils.copyProperties(target, source);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(source.getParam());  // param
        System.out.println(source.getParameter());  // parameter
        System.out.println(target.getParam()); // param
        System.out.println(target.getParameter()); // parameter
    }

    public static class A {
        String param;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }
    }

    public static class B extends A {
        String parameter;

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }

    public static class C {
        String param;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

    }

    public static class D extends C {
        String parameter;

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }
}