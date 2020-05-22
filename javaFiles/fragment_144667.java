@Override
protected Boolean doInBackground() throws Exception {

//ImageDeployer imageDeployer = new ImageDeployer();
//imageDeployer.makeAConnection();
...
ImageDeployer imageDeployer = new OVFImageDeployer(volID, oS, imageName, channel);
...
}