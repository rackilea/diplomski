class MyTextArea extends TextArea implements MyListener {

    @Override
    public void actionPerformed(MyEvent e) {
        System.out.println(e.getArg());
    }
}