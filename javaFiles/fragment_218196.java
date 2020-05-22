LinkedListNode<Double> nod1 = linkedList1.First;
LinkedListNode<Double> nod2 = linkedList2.First;
while (nod1 != null && nod2 != null)
{
    Double d = nod1.Value + nod2.Value;              
    nod1.Value = d;
    nod1 = nod1.Next;
    nod2 = nod2.Next;
}