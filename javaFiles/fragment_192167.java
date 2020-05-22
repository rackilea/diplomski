while (loops > 0){
        System.out.println("Enter " + outputno +". name:");
        canidatename = input.next();
        System.out.println("Enter votes:");
        canidatevotes = input.nextInt();
        loops = loops - 1;
        canidateArray[outputno-1] = new Canidate(canidatename, canidatevotes);
        outputno = outputno + 1;
    }