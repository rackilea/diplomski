RunInstancesRequest runInstancesRequest =
   new RunInstancesRequest();

runInstancesRequest.withImageId("ami-4b814f22") // This is a base image, for example a ubuntu or linux instance
                   .withInstanceType("m1.small") // The size of the instance, these cost more the more powerful they are
                   .withMinCount(1) // Minimum amount of instances you want to launch
                   .withMaxCount(1); // Maximum amount of instances you want to launch