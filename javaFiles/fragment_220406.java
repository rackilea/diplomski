for(Item item : ModItems.ITEMS)
{
    //nop;
}

// We are out of the for-loop scope. There is no "item" here...
{
    if (item instanceof IHasModel)
    {
        ((IHasModel)item).registerModels();
    }
}