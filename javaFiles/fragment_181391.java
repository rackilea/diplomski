if (isSendingData) {
        dataQueue.add(data);
        return;
    }

    isSendingData = true;