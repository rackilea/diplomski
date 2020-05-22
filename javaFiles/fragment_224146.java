for (RssItem item : rssReader.getItems())
{
    adapterItem adaptItem = new adapterItem();
    adaptItem.setHeader(item.getTitle());
    adaptItem.setDate(item.getDate());
    adapter.add(adaptItem);
    i++;
    if(i == 7)
    {
       break;
    }
}