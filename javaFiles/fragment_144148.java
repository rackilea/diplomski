String[] arr = {"1","ab","aaa","sdfsdfew","ssdd"};
for(String s : arr){
    if(s.length()>3){
        arr = ArrayUtils.removeElement(arr, s);
    }
}

System.out.println(ArrayUtils.toString(arr));