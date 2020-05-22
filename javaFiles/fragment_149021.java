private JPanel createMiddlePanel()
{
   pnlMiddle = new JPanel();
   txaResults = new JTextArea(10, 30);
   jsp = new JScrollPane(txaResults);
   jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   pnlMiddle.add(jsp);

   return pnlMiddle;
 }