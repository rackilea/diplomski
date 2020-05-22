String[] splits = lessonResources.split("\\s+");
    for(String s: splits){
            link = new Hyperlink(s);
            lessonResourcesTextFlow.getChildren().add(link);


            link.setOnAction((ActionEvent e) -> {  
                    linked = new File(s); 
                            try {
                                if(Desktop.isDesktopSupported()){
                                    try {
                                        Desktop.getDesktop().open(linked);
                                    } catch (IOException ex) {
                                        Logger.getLogger(LessonPlanController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                            } catch (Exception e) {
                                System.out.println(e);
                            }
            }); 

    }