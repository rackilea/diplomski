Collections.sort(extractedDataByKeyactivity, new Comparator<RSSQuestion>() {

    @Override
    public int compare(RSSQuestion o1, RSSQuestion o2) {
        int keyActivityCompare = o1.getKeyActivity().compareTo(o2.getKeyActivity());
        if (keyActivityCompare == 0)
          return o1.getSubActivity().compareTo(o2.getSubActivity());
        return keyActivityCompare;
    }
});