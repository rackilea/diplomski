private void createLayout()
{
   m_layout = new GroupLayout(YOUR_PANEL);
   YOUR_PANEL.setLayout(m_layout);

   //This SequentialGroup is used for the VerticalGroup
   m_verticalSg = m_layout.createSequentialGroup();
   m_verticalSg.addContainerGap();

   //Two ParallelGroups are used. One for all labels and the other one for all textfields
   m_horizontalPgLabels = m_layout.createParallelGroup(GroupLayout.Alignment.LEADING);
   m_horizontalPgTextfields = m_layout.createParallelGroup(GroupLayout.Alignment.LEADING);

   //These component lists are used for linkSize() -> Equalize components width
   m_labelList = new ArrayList<>();
   m_textFieldList = new ArrayList<>();

   m_layout.setHorizontalGroup(m_layout.createParallelGroup()
                    .addGroup(m_layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(m_horizontalPgLabels)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED) //Create gap between horizontal groups
                    .addGroup(m_horizontalPgTextfields)
                    .addContainerGap()));

   m_layout.setVerticalGroup(m_layout.createParallelGroup().addGroup(m_verticalSg.addContainerGap()));
}