case 2:
    // You may not even require this check, if it's ensured to be non-null.
    if (allEvents != null) {
        Event.headersEventNo();
        for (int i = 0; i < allEvents.length; i++)
        {
            if (allEvents[i] != null)
            {
                System.out.println(allEvents[i].toString());
            }
        }
    }

    break;