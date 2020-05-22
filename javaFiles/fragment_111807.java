final ArrayList<Integer> nums = new ArrayList<Integer>();
        final ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 25; i++) {
            final int rand = Double.valueOf(Math.random() * 255).intValue();
            nums.add(rand);
        }
        System.out.println(nums);
        outer: for (Integer current : nums) {
            // result collection is reevaluated here 
            // and is not modified inside the inner for loop
            // so, accessing it is safe
            for (Integer other : result) {
                if (Math.abs(current - other) < 5) {
                    // there is a too close value, do not put, skip the check
                    continue outer;
                }
            }
            // a too close value doesn't exist - add object
            result.add(current);
        }
        // here you may assing new collection to the old reference, uncomment next line
        // nums = results;