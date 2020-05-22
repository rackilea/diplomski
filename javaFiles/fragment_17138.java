double result = 0;
    Integer [] nums = coefficients.toArray(new Integer[0]);
    for(int i = 0; i < nums.length; i++){
        result = result *x + nums[i];
    }
    System.out.println(result);