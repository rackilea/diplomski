if (n==0||k==0||k>n) {
        if (k==0) // this condition will make sure that only complete
                  // sequences of k elements will be printed
            System.out.println(sequence);
    } else {
        showTeam(sequence+start,(char)(start+1),n-1,k-1);
        showTeam(sequence,(char)(start+1),n-1,k);
    }