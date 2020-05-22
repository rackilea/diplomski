Runtime.exec(new String[] {
   "ssh",
   "-i", myKey,
   "ubuntu@ec2-56-75-88-183.eu-west-1.compute.amazonaws.com",
   "./runScript 8000"
})