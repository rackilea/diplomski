linkedList::linkedList()
{  
    sentinel.last = &sentinel;  
    sentinel.next = &sentinel;  
    sentinel.str = "I am sentinel!!";  
}