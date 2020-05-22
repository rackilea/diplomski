Component ca[] = getContentPane().getComponents();
System.out.println("ca = " + Arrays.toString(ca));
int i = 0;
for(Component c: ca) {
    if(JTextField.class.isAssignableFrom(c.getClass())) {
        JTextField tf = (JTextField) c;
        tf.setText("blah -"+(++i));
    }
}