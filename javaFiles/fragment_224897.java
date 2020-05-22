String str = "BhilaiPuneBanglore";
String[] arr = str.split("(?=\\p{Upper})");

for (int i = 0 ; i < arr.length; i++)
    {
        System.out.println(arr[i]);
    }