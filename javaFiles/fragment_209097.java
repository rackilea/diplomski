public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
    String[] nums1 = br.readLine().split(":")[1].split(" ");
    String[] nums2 = br.readLine().split(":")[1].split(" ");
    br.close();
    System.out.println("The maximum number is " + Math.max(Integer.parseInt(nums1[0]), Integer.parseInt(nums1[1])));
    System.out.println("The sum is " + (Integer.parseInt(nums2[0]) + Integer.parseInt(nums2[1])));    
}