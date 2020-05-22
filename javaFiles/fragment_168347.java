private static int getYPosition(ExpandBar bar, int position)
{
    /* Calculate the position */
    int y = 0;
    for(int i = 0; i < position; i++)
    {
        /* Incorporate the spacing */
        y += bar.getSpacing();

        /* Get the item (On LINUX, use this line) */
        ExpandItem item = bar.getItem(bar.getItemCount() - 1 - i);
        /* Get the item (On WINDOWS, use this line) */
        //ExpandItem item = bar.getItem(i);

        /* Add the header height */
        y += item.getHeaderHeight();

        /* If the item is expanded, add it's height as well */
        if(item.getExpanded())
            y += item.getHeight();
    }

    return y;
}