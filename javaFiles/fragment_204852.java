if (obj instanceof MessageList)
{
    MessageList messageList = (MessageList) obj;

    int listHeight = 0;
    for(Message message : messageList.getList())
    {
        message.obtainFontDimension(g2d);
        listHeight += message.getHeight()+message.getDescent();
    }

    position = new Point(box.x, box.y);
    Dimension listDimension = new Dimension(0, listHeight);
    if( allignment == Allignment.MIDDLE || allignment == Allignment.MIDDLE_LEFT
    || allignment == Allignment.ABSOLUTE_MIDDLE || allignment == Allignment.MIDDLE_RIGHT)
    {
        position = allign(Allignment.MIDDLE, position, listDimension, box, true);
    }
    else if(allignment == Allignment.BOTTOM || allignment == Allignment.BOTTOM_LEFT
    ||       allignment == Allignment.BOTTOM_CENTER ||  allignment == Allignment.BOTTOM_RIGHT)
    {
        position = allign(Allignment.BOTTOM, position, listDimension, box, true); 
    }
    else
    {
        position = allign(Allignment.TOP, position, listDimension, box, true); 
    }

    for(Message message : messageList.getList())
    {
        position.y += message.getHeight(); // prepare the offset
        message.setDrawPosition(allign(allignment, position, new Dimension(message.getWidth(), 0), box, true));
        position.y += message.getDescent(); // add descending offset for next itteration
    }
}