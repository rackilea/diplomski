SRC_Main load =new SRC_Main();
load.OpenFile();
CarsRec[] arrMRecords=load.ReadFile();
load.setCarRecs(arrMRecords); 
load.setVisible(true);
this.dispose();