ParallelGroup pGroup = gl
        .createParallelGroup(GroupLayout.Alignment.CENTER);
hGroup.addGroup(pGroup);
for (JCheckBox c : listCustomiseJCB) {
    pGroup.addComponent(c);
}