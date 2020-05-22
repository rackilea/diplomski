for (int i=0; i< hList.size(); i++) {
        for (String mID: ss) {
            if (hList.get(i).getmId().equals(mID)) {
                hList.get(i).remove(i);
            }
        }
    }