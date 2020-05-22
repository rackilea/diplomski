if(ques.getName().equalsIgnoreCase("question")){
                    //read 
                    System.out.println(ques.getTextTrim());
                        //write
                    ques.removeContent();
                    ques.addContent(new CDATA("question"+a));
                }