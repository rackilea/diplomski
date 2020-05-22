public class MyApplication {
    private boolean isSetByProgram;
    private String item;

    // ...

        jcb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if (isSetByProgram) {
                    return;
                }
                item = jcb1.getSelectedItem();
            }
        });

        //Now set by program
        isSetByProgram = true;
        jcb1.setSelectedItem("customItem1");
        EventQueue.invokeLater(() -> { isSetByProgram = false; });