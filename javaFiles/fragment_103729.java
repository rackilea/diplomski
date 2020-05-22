private static int permute(String str, int l, int r, ArrayList<String> list){

    if (l == r) {
        list.add(str);
    }
    else {
        for (int i = l; i <= r; i++) {
            str = swap(str,l,i);
            permute(str, l+1, r, list);
            str = swap(str,l,i);
        }
    }
    return list.size();
}