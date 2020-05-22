package com.sel2in.sort;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;

    /** based on http://www.vogella.com/articles/JavaAlgorithmsMergesort/article.html */
    public class MergeSort<T> {

        private List<T> items;
        private List<T> helper;

        private Comparator<T> comprtr;
        private int cnt;

        public void sort(T[] values, Comparator<T> comprtr) {
            items = new ArrayList<T>();
            items.addAll(Arrays.asList(values));

            cnt = values.length;
            this.helper = new ArrayList<T>(cnt);
            this.comprtr = comprtr;
            mergesort(0, cnt - 1);
        }

        public void sort(List<T> values, Comparator<T> comprtr) {
            items = values;
            //items.addAll(Arrays.asList(values));
            cnt = values.size();
            this.helper = new ArrayList<T>(cnt);
            helper.addAll(items);
            this.comprtr = comprtr;
            mergesort(0, cnt - 1);
        }   

        private void mergesort(int low, int high) {
            // Check if low is smaller then high, if not then the array is sorted
            if (low < high) {
                // Get the index of the element which is in the middle
                int middle = low + (high - low) / 2;
                // Sort the left side of the array
                mergesort(low, middle);
                // Sort the right side of the array
                mergesort(middle + 1, high);
                // Combine them both
                merge(low, middle, high);
            }
        }

        private void merge(int low, int middle, int high) {

            // Copy both parts into the helper array
            for (int i = low; i <= high; i++) {
                // helper[i] = items[i];
                helper.set(i, items.get(i));
            }

            int i = low;
            int j = middle + 1;
            int k = low;
            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
                int cm = comprtr.compare(helper.get(i), helper.get(j));
                //(helper[i] <= helper[j]) 
                if (cm <= 0) {
                    //items[k] = helper[i];
                    items.set(k, helper.get(i));
                    i++;
                } else {
                    //items[k] = helper[j];
                    items.set(k, helper.get(j));
                    j++;
                }
                k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
                //items[k] = helper[i];
                items.set(k, helper.get(i));
                k++;
                i++;
            }

        }

    }