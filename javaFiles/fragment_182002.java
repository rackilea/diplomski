while(low<=high){
        if(a.get(mid)<b){
            low = mid+1;
            mid = (low+high)/2;                
        }
        else if(a.get(mid) > b){
            high = mid-1;
            mid = (low+high)/2;                
        }
        else return mid;
    }

    return low;//handles the case when no match is found.