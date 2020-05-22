Element trackDictNode = null;
{
   Node temp = keyNode.nextSibling();
   while (temp != null && !(temp instanceof Element)) temp = temp.nextSibling();
   trackDictNode = temp;

}