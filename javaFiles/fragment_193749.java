JButton investButton = new JButton("Invest");
JButton articleButton = new JButton("Article");
JButton ignoreButton = new JButton("Ignore");

layout.setVerticalGroup(
    layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(investButton))                       
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(ignoreButton))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(articleButton)));

layout.setHorizontalGroup(
    layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(investButton)
            .addComponent(ignoreButton)
            .addComponent(articleButton)));