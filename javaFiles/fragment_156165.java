VBox vb = new VBox();
vb.getChildren().addAll(tuitionreport,totStudents,totalFees);
vb.setSpacing(10);

VBox vbez = new VBox();
vbez.getChildren().addAll(vb,instructors,hboxtitle);

for(int m=0;m<test.length;m++) {
  HBox hb = new HBox();

  System.out.println("Test.length's size : " + test.length);
  System.out.println("TeacherLabels's count : " + teacherlabels.size());
  hb.getChildren().addAll(teacherlabels.get(m),eachlecturertotstudents.get(m),subincome.get(m),teacherpayments.get(m));
  hb.setSpacing(10);


  vbez.getChildren().add(hb);

}

vbez.getChildren().addAll(linez,allpaymenta,tuitionincomea);
this.setScene(new Scene(vbez, 2000, 2000));
this.show();