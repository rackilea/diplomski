public class MyListener implements Listener {

@EventHandler
public void craftEvent(PrepareItemCraftEvent event) {
    ItemStack[] contents = event.getInventory().getContents();
    ItemStack firstInContents = contents[0];

    if((firstInContents.getType()==Material.SLIME_BALL) && (firstInContents.getAmount() == 9)) {
        firstInContents.setAmount(4);
    }

}
}