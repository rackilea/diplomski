for (int i = 0; i <= data.length; i++)
    if ((data[i] < 0) || (data[i] > 255)) {
        parts = new int[]{0,0,0,0};
        break;
    } else {
        parts[i] = data[i];
    }