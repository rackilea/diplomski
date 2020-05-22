public void quickSort(int begin, int end) {
        if (begin >= end) {
            return;
        }
        int lower = begin;
        int higher = end;

        int pivot = zahlenliste[lower + (higher - lower) / 2];

        while (lower <= higher) {
            while (zahlenliste[lower] < pivot) {
                lower++;
            }
            while (zahlenliste[higher] > pivot) {
                higher--;
            }
            if (lower <= higher) {                  // fix
                swap(zahlenliste, lower, higher);
                lower++;                            // fix
                higher--;                           // fix
            }
        }

        if (begin < lower-1) {                      // fix
            quickSort(begin, lower-1);              // fix
        }

        if (lower < end) {
            quickSort(lower, end);
        }
    }

    // fix (void)
    public void swap(int[] zahlenliste, int begin, int end) {
        int temp = zahlenliste[begin];
        zahlenliste[begin] = zahlenliste[end];
        zahlenliste[end] = temp;
    }