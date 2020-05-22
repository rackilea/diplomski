public List<Message> getMessages(int start, int end, Date earliestDate) {
        if (start < 1 || end < 1 || end < start) {

            throw new MessagingException(String.format(Locale.US, "Invalid message set %d %d",
                    start, end));
        }
        int length = end - start;
        ItemView view = new ItemView(length);
        FindItemsResults<Item> findresults = null;
        try {
            if (earliestDate == null) {
                findresults = mService.findItems(mFolder.getId(), view);
            }
            else{
                SearchFilter filter = new SearchFilter.IsGreaterThanOrEqualTo(ItemSchema.DateTimeReceived, earliestDate);
                findresults = mService.findItems(mFolder.getId(), filter,view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Message> messages = new ArrayList<Message>();
        int i = 0;
        for (Item item : findresults) {
            ItemId id = null;
            EmailMessage message = null;

            try {
                id = item.getId();
                message = new EmailMessage(mService);
                message.bind(mService, id);
            } catch (ServiceLocalException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            messages.add(message);

    }

        return messages;
    }