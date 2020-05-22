@EventHandler
public void craft(CraftItemEvent e){
  if(e.getInventory() instanceof CraftingInventory){
    CraftingInventory inv = (CraftingInventory) e.getInventory();
    if(inv.getSize() != 4 && e.getRecipe().equals(lvl1ArmorHelmetRecipe())){
      ItemStack helm = inv.getMatrix()[4];//get the middle item in the bench, which is the helmet
      if(helm.hasItemMeta()){//make sure the helmet has item meta
        if(helm.getItemMeta().getDisplayName().equals("Better Helmet")){//make sure the helmet's display name is 'Better Helmet'
          //you're done! It works! Do something like tell the player "you have crafted better armor" or something here.
          return;
        }
      }
      //the return; above would have been called if the crafting had succeeded. When it got called, the remainder of this method would not run (this part will not be run if the crafting has succeeded)
      //send the player a message to make it more realistic here. For my wizardry server I use: 'One of thee items used was incorrect, and unbalanced the energy. The death block hath been destroyed'
      e.setCanceled(true);
      e.setResult(new ItemStack(Material.AIR));
    }
  }
}