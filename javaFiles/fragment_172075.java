private MyVector3(Parcel in) {
  double[] data = new double[3];
  in.readDoubleArray(data);

  this.x= data[0];
  this.y= data[1];
  this.z= data[2];
}