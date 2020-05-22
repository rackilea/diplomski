interface Init {
    public void init();
}

class ServletUtils implements Init {
    @Override
    public void init() {
        System.out.println("inside ServletUtils's init method");
    }
}

class ServletAdicional extends ServletUtils {
    @Override
    public void init() {
        System.out.println("inside ServletAdicional's init method");
    }
}

public static void main(String[] args) throws Exception {

    Init init = new ServletAdicional();
    init.init();
}