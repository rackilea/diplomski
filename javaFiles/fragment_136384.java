if(i==max) {
            swap(a,max,a.length-1-i);
            swap(a,min,i);
        }else {
            swap(a,min,i);
            swap(a,max,(a.length-1)-i);
        }