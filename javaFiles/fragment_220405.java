for(Item item : ModItems.ITEMS);
{
    if (item instanceof IHasModel)
    {
        ((IHasModel)item).registerModels();
    }
}