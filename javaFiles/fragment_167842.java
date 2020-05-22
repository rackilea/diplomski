private void addNewRow()
{
   if(m_layout == null)
      createLayout();

   Dimension dimLabel = new Dimension(100, 15);
   Dimension dimTextfield = new Dimension(200, 20);

   //Create a new label
   JLabel lbl = new JLabel();
   lbl.setText("Your text");
   lbl.setIcon(null/*Your icon*/);
   lbl.setSize(dimLabel);
   lbl.setPreferredSize(dimLabel);

   //Create a new textfield
   JTextField txtField = new JTextField();
   txtField.setSize(dimTextfield);
   txtField.setPreferredSize(dimTextfield);

   //Add components to arrays and increase index
   m_labelList.add(lbl);
   m_textFieldList.add(txtField);

   //Create new ParallelGroup for the vertical SequentialGroup
   ParallelGroup newVerticalParallelGroup = m_layout.createParallelGroup(GroupLayout.Alignment.LEADING);
   newVerticalParallelGroup.addComponent(lbl);
   newVerticalParallelGroup.addComponent(txtField);
   m_verticalSg.addGroup(newVerticalParallelGroup);
        m_verticalSg.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);

   //Add the new label to the horizontal label group
   m_horizontalPgLabels.addComponent(lbl, GroupLayout.Alignment.CENTER);
   //Add the new textfield to the horizontal textfield group
   m_horizontalPgTextfields.addComponent(txtField);

   m_layout.linkSize(SwingConstants.HORIZONTAL, m_labelList.toArray(new Component[m_labelList.size()]));
   m_layout.linkSize(SwingConstants.HORIZONTAL, m_textFieldList.toArray(new Component[m_textFieldList.size()]));
}