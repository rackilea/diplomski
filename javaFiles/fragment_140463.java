public static void main(String[] args) throws IOException {

        char arr[] = new char[5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter input characters and press enter: "); 
        for(int i=0; i<arr.length; i++) {
            arr[i] = (char) br.read();
        }       
        br.close();
        Arrays.sort(arr);
            System.out.println("Sorted Array: "+String.valueOf(arr));   
    }