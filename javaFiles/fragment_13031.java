vm.setCloudletScheduler(new CloudletSchedulerCompletelyFair());
for(int i=0; i < 10; i++){
    Cloudlet c = new CloudletSimple(CLOUDLET_LEN, CLOUDLET_PES);
    c.setPriority(i);  //you must define the priority in your own way
    cloudletList.add(c);
}