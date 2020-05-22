//number of elements in result array
int count = new Random().nextInt(arr.length);


ArrayList<String> result = new ArrayList<String>();
for(int i=0; i<count; i++){
    //random index of element that must be added to result
    int index = new Random().nextInt(arr.length);
    result.add(arr[index]);
}