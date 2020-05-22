while(generator.hasMorePermutations())
    {
        // get a permutation
        temp = generator.nextPermutation();
        // test for contains
        if(array.contains(temp))
        {

        }
        else
        {
            // insert a new permutation instead of temp
            array.add(generator.nextPermutation());
            // print yet another new permutation instead of temp
            System.out.println(generator.nextPermutation());
            i++;
        }