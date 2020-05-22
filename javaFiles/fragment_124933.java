public void setProteinData(ProteinData proteinData) {
      this.proteinData = proteinData;
      if (proteinData != null) {
          proteinData.setUser(this);
      }
  }