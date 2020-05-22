int index = 0;
        for (int whit : arr) {
            if (whit % 2 == 0)
                arr = ArrayUtils.remove(arr, index);
            else 
                index++;
        }