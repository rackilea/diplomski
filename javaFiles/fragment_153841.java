public class CreatePdf{
   private Font bigFont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 12, Font.BOLD, new Color(0, 0, 0));
   private Font smallFont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 8, Font.NORMAL, new Color(0, 0, 0));

   public void create(){
      Paragraph parag1=new Paragraph("Number: ",bigFont);//This gonna be bold font
      Paragraph parag2=new Paragraph("12", smallFont); //This gonna be normal font
      Paragraph comb=new Paragraph(); 
      comb.add(new Chunk(parag1)) 
      comb.add(new Chunk(parag2)); 
   }
}