newText = newText.toLowerCase();
        ArrayList<ClientTask> newList = new ArrayList();

        for (ClientTask c : clienttask) {
               String name = c.get_clienttaskname().toLowerCase();
            if (name.contains(newText)) {
                newList.add(c);
            }

            Log.d(TAG, "the usual fail ");
        }
        recycler.setFilter(newList);
        return true;