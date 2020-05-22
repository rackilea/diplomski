class MyRandomClass {
    int thisIsNotAGlobal;  //It's an instance variable.
    ...
    void someFoobarMethod(...) {
        JButton button = ...;
        Thingy someThingy = ...;

        button.addActionListener(
             new ActionListener()
             {
                public void actionPerformed(ActionEvent event)
                {
                    thisIsNotAGlobal++;
                    someThingy.methodWithSideEffects(...);
                }
             });
    }
}