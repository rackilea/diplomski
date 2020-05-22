if (val.iscil > 0) {
      val.tdd = (val.iscil<=20) ? 5.0 :
          (val.iscil <= 50) ? 8.0 :
          (val.iscil <= 100) ? 12.0 :
          (val.iscil <= 1000) ? 15.0 :
          20.0
  }