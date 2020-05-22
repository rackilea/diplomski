static int isFilter(int[] a){
        boolean found9 = false, found11 = false, found7 = false, found13 = false;
        for (int i = 0; i < a.length; i++) {
            switch (a[i]) {
            case 7:
                found7 = true;
                break;
            case 9:
                found9 = true;
                break;
            case 11:
                found11 = true;
                break;
            case 13:
                found13 = true;
                break;
            }
        }
        if(found9 && found11) return 1;
        if(found7 && !found13) return 1;
        return 0;
    }