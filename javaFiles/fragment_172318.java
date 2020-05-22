int arr0 = array[0];

array[0] = (int) Math.abs(arr0-array[1]);

array[1] = (int) Math.abs(array[1]-array[2]);

array[2] = (int) Math.abs(array[2]-array[3]);

array[3] = (int) Math.abs(array[3]-arr0);