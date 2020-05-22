public void search(MenuItem[] items,
                   int        selected,
                   int        depth,
                   double     currentCost,
                   double     maxCost)
{
    if(currentCost > maxCost)
    {
        // too expensive
        return;
    }

    if(currentCost > bestCost)
    {
        // New best combination! Save it.
        bestCost = currentCost;
        bestPurchaseSet = selected;
    }

    if(depth >= items.length)
    {
        // run out of food types
        return;
    }

    // if we do choose this item, then we mark it as selected and increase the cost of this order.
    search(items, selected | (0x1 << depth), depth + 1, currentCost + items[depth].cost, maxCost);

    // if we don't choose this item
    search(items, selected, depth + 1, currentCost, maxCost);
}