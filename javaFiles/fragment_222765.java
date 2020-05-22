for(j=0; j<group.numChildren(); j++) {
    Node ni=group.getChild(j);
    if(ni instanceof TransformGroup) {
      Transform3D tdi=new Transform3D();
      TransformGroup tgi=(TransformGroup)group.getChild(j);
      tgi.getTransform(tdi);
      Transform3D rotation = new Transform3D();
      rotation.rotX(Math.toRadians(0.001*i));
      tdi.mul(rotation);
      tgi.setTransform(tdi);
    }
}