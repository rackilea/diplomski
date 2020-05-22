binsearch(a,val,left,right){
    if(left==right) return left;
    mid = (left+right+1)/2;
    if(a[mid] > val)
        return binsearch(a,val,left,mid-1);
    else
        return binsearch(a,val,mid,right);
}