PurchasePlan plan = new PurchasePlan();
plan.withName("name");
plan.withPublisher("publisher");
plan.withProduct("prodcut");

VirtualMachine linuxVM = azure.virtualMachines().define(name)
                .withRegion(Region.US_WEST)
                .withExistingResourceGroup(myRg)
                .withExistingPrimaryNetwork(network)
                .withSubnet("subnet1")
                .withPrimaryPrivateIPAddressDynamic()
                .withNewPrimaryPublicIPAddress("ip-" + name)
                .withLatestLinuxImage("publisher", "offer", "sku")
                .withRootUsername("root")
                .withRootPassword("some password")
                .withSize(VirtualMachineSizeTypes.BASIC_A0)
                .withPlan(plan)
                .create();