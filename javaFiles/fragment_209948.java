public void removeLast()
{
    if (front != null && front.next != null)
    {
        IntNode secondtolast = front;
        while (secondtolast.next.next != null)
        {
            secondtolast = secondtolast.next;
        }
        secondtolast.next = null;
    }
}