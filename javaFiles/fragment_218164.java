public int[] getAllNumbers(int[] nums, boolean onlyPositiveNums){
    if(onlyPositiveNums){
        return getAllPositiveNumbers(nums);
    } else {
        return getAllNegativeNumbers(nums);
    }
}