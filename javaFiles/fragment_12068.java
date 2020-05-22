binsearch(a,val,left,right){
    if(left==right) return left;
    mid = (left+right)/2;
    if(a[mid] < val)
        return binsearch(a,val,mid+1,right);
    else
        return binsearch(a,val,left,mid);
}