private void getPerm(int n, int[] a, ArrayList<Integer> tmp, ArrayList<List<Integer>> result)
{
    if(n == 0){
        ArrayList<Integer> toAdd = new ArrayList<Integer>(tmp);
        result.add(toAdd);
        // don't clear tmp here
        return;
    }
    for(int i = 0; i < n; i++){
        tmp.add(a[i]);
        int[] b = new int[n-1];
        int k = 0;
        int j = 0;
        while(k<b.length){
            if(a[i]==a[j]){j++;}
            else{b[k]=a[j]; k++; j++;}
        }

        getPerm(n-1, b, tmp, result);
        tmp.remove(tmp.size()-1); // remove the last element added to tmp
    }
}