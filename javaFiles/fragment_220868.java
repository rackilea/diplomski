@Override
public void actionPerformed(ActionEvent e) {
     String command = e.getActionCommand();

        if (command.equals("1")) {
            myMethod();
            numbers.add(1);
            System.out.println("1");
        }
        if (command.equals("2")) {
            numbers.add(2);
            System.out.println("2");
        }

}