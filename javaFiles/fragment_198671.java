public static void form_to_create(String title, Boolean mdi_child){
        Form frm;
        if (mdi_child) {
            frm = new Form_child();
        }else{
            frm = new Form();
        }

        frm.init(title);
        frm.doSomething();
    }