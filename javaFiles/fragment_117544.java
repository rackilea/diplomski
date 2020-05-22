int node = 0;
            int left = 1;
            int right = 2;
            int next;


            if ((heapArr[left] == null) && (heapArr[right] == null))
                next = count-1;
            else if (heapArr[right] == null)
                next = left;
            else if (heapArr[left].compareTo(heapArr[right]) < 0)
                next = left;
            else
                next = right;