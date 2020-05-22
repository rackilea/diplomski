for (int i = 0; i<arr.length; i++) {
    if(arr[i].length()>0){
        System.out.println(arr[i]);

        String str = arr[i].trim();
        String[] arr2 = str.split("x");

        String str2 = arr2[0];

        System.out.println(str2); //prints coefficient
        System.out.println(str.substring(str.indexOf('^')+1)); //prints exponent
        System.out.println(Integer.parseInt(str2));
    }
}