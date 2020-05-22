String[][] databaseToArray = {
  //{"Name", "Channel", "Description", "Amount", "isReady"},
    {"John", "Nick",    "likes",       "2",      "yes"    },
    {"Drew", "MTV",     "dislikes",    "4",      "no"     },
    {"Fred", "CNN",     "okay",        "3",      "no"     },
    {"Beth", "Fox",     "valid",       "1",      "yes"    }
};

Arrays.sort(databaseToArray, new Comparator<String[]>() {
    public int compare(String[] a, String[] b) {
        return a[3].compareTo(b[3]);
    }
});