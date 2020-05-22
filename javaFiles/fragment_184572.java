if (elements==2){
 int[] center = [];
 int[] left = makeArray(data,0,1);
 int[] right =makeArray(data,1,1);

 mergesort(left); //you can call these methods or not, on a empty or 1 element array they dont have an effect
 mergesort(center);
 mergesort(right);

 merge(data, left, center, right); //it should work well when center is an empty array