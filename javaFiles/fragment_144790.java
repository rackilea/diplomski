Dye dye = new Dye();
dye.setColor(DyeColor.RED);
  ItemStack dye4 = dye.toItemStack();
  dye4.setAmount(1);
dye.setColor(DyeColor.ORANGE);
  ItemStack dye3 = dye.toItemStack();
  dye3.setAmount(1);
dye.setColor(DyeColor.PURPLE);
  ItemStack dye2 = dye.toItemStack();
  dye2.setAmount(1);
dye.setColor(DyeColor.CYAN);
  ItemStack dye1 = dye.toItemStack();
  dye1.setAmount(1);
dye.setColor(DyeColor.GRAY);
  ItemStack dye0 = dye.toItemStack();
  dye0.setAmount(1);

ImmutableList<ItemStack> dyes 
  = ImmutableList.of(dye0, dye1, dye2, dye3, dye4);

p.getOpenInventory().getTopInventory().setItem(1, dyes.get(0));