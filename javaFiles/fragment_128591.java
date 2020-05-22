public static void main(String[] args) {
    String numbers = "0020020074#223#522620#1#9#0:" +
                     "0024202968#223#522620#1#59#0:" +
                     "0024039694#226#522620#3#1282#0:" +
                     "0024378742#223#522620#2#51#0";

    String[] nums = numbers.split(":");

    int i = 0;
    while(i < nums.length){

        if(nums[i].split("#")[3].charAt(0) == '1')
            System.out.println(nums[i].split("#")[0]);
        else if(nums[i].split("#")[3].charAt(0) == '2')
            System.out.println(nums[i].split("#")[0]);
        else
            System.out.println(nums[i].split("#")[1]);

        i++;
    }

}