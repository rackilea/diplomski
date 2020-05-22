Comparator<String> startsWithComparator = new Comparator<String>() {
            public int compare(String currentItem, String key) {
                if(currentItem.startsWith(key)) {
                    return 0;
                }
                return currentItem.compareTo(key);
            }
        };

int index = Collections.binarySearch(items, "contact.", startsWithComparator);