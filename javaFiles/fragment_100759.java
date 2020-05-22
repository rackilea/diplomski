Link pcurrent = pfirst;
    Link previous = null;    // Add this declaration

    Link newLink = new Link(key, value);
    if(pcurrent != null)
    {
        while(pcurrent.key <= newLink.key && pcurrent.next != null)
        {
            previous = pcurrent;     // Update previous
            pcurrent = pcurrent.next;
        }

        // insert newLink between previous and next
        previous.next = newLink;
        newLink.next = current;
    }