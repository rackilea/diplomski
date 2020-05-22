1145
1146    private static void More ...mergeSort(Object[] src,
1147                                  Object[] dest,
1148                                  int low,
1149                                  int high,
1150                                  int off) {
1151        int length = high - low;
1152
1153        // Insertion sort on smallest arrays
1154        if (length < INSERTIONSORT_THRESHOLD) {
1155            for (int i=low; i<high; i++)
1156                for (int j=i; j>low &&
1157                         ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--)
1158                    swap(dest, j, j-1);
1159            return;
1160        }
1161
1162        // Recursively sort halves of dest into src
1163        int destLow  = low;
1164        int destHigh = high;
1165        low  += off;
1166        high += off;
1167        int mid = (low + high) >>> 1;
1168        mergeSort(dest, src, low, mid, -off);
1169        mergeSort(dest, src, mid, high, -off);
1170
1171        // If list is already sorted, just copy from src to dest.  This is an
1172        // optimization that results in faster sorts for nearly ordered lists.
1173        if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
1174            System.arraycopy(src, low, dest, destLow, length);
1175            return;
1176        }
1177
1178        // Merge sorted halves (now in src) into dest
1179        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
1180            if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0)
1181                dest[i] = src[p++];
1182            else
1183                dest[i] = src[q++];
1184        }
1185    }