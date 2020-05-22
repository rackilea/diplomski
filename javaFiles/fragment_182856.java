AttachedDisk dataDisk = new AttachedDisk();        
dataDisk.setSource("projects/project/zones/zone/disks/diskName");
dataDisk.setType("PERSISTENT");
dataDisk.setMode("READ_WRITE");
dataDisk.setAutoDelete(true);

//attach disk to instance

Compute.Instances.AttachDisk attachDisk=compute.instances().attachDisk(projectId, zone, instanceName, dataDisk);