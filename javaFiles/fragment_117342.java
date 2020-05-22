Font plainFont= new Font(Font.FontFamily.COURIER, 14,
                    Font.NORMAL);

for (int i = 0; i < listEarnings.size(); i++) {
    String temp1 = listEarnings.get(i).getEarningsDescriptionSS();
    String temp2 = listEarnings.get(i).getEarningsAmountSS();


      table.addCell( new Phrase(Element.ALIGN_LEFT,temp1,plainFont));
     table.addCell( new Phrase(Element.ALIGN_LEFT,temp2,plainFont));
   // table.addCell(temp1); 
   // table.addCell(temp2);
}