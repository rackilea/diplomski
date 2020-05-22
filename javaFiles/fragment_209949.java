public void replace(int oldVal, int newVal)
{
    while (front.next != null)
    {
        if (front.val == oldVal)
        {
            front.val = newVal;
        }
        front = front.next;
    } 
}