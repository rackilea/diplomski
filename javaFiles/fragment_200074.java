float amount = 3.33f;

        int allocations = 2;

        double average = amount/allocations;

        System.out.println("ACTUAL AVERAGE "+average);

        double rounded = Math.round(average * 100.0) / 100.0;

        System.out.println("ROUNDED VALUE: "+rounded);

        double adjustment = average - rounded;

        adjustment*=allocations; //-- FOR EACH ALLOCATION

        for(int i=1; i<allocations; i++){
            System.out.println("Allocation :" +i + " = "+rounded);
        }

        //-- ADDING ADJUSTED ROUNDING AMOUNT TO LAST ONE
        double adjustedAmount = Math.round((rounded+adjustment) * 100.0) / 100.0;

        System.out.println("Allocation :" +allocations +" = " + adjustedAmount);