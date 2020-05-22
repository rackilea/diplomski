while (more items, set iterator equal to next node)
{
   deepCurrNode <-- get deep copy of iterator (this is the item i want to add to my newList)
   Set the tail's next to deepCurrNode to link them
   Set deepCurrNode's previous to the tail to link backwards
   Set the Tail to point to the new tail of the list (deepCurrNode)