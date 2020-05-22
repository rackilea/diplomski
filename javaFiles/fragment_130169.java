public void setTemp(double temp, char scale){
    // - sets the objects temperature to that specified using the 
    //   specified scale ('K', 'C' or 'F')
    if (scale == 'K'){
      this.temp = temp + 273;
    } else if (scale == 'C') {
      this.temp = temp;
    } else if (scale == 'F') {
      this.temp = ((9 * temp) / 5 ) + 32;
  }
}