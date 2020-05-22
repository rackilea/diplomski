for (int i=0;i<android.length;i++) { // < instead of <=, don't hardcode the length
        if (android[i] == null) {
            android[i] = a;
            break;                       // once we insert a, stop looping
        }
    }