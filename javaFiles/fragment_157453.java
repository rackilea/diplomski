public void paintComponent (Graphics page)
{
   super.paintComponent(page);

   for (Building bldg : bs) {
     bldg.draw(page);
   }
}