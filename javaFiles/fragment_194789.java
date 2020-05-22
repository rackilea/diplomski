package com;

public class Data {
  private SubData dCharg;
  private SubData dICharg;
  private SubData dMaktx;
  private SubData dStatus;
  private SubData dStock;

  public SubData getDCharg() {
    return this.dCharg;
  }

  public void setDCharg(SubData dCharg) {
    this.dCharg = dCharg;
  }

  public SubData getDICharg() {
    return this.dICharg;
  } 

  public void setDICharg(SubData dICharg) {
    this.dICharg = dICharg;
  }
}

public class SubData {
   private String TEXT;
   public String getTEXT() {
    return this.TEXT;
   }

   public void setTEXT(String TEXT) {
    this.TEXT = TEXT;
   }
}