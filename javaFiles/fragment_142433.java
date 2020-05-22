// log overflow events and trigger reprocess later.
if (kind == OVERFLOW) 
{
    logger.warn("File listener recieved an overflow event.  You should probably check into this");
    overflowTriggeredFlag = true;
    continue;
}