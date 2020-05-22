String excelTitle=  DealTitle.replaceAll("[^\\w\\s\\-_]", "");

String pageTitle=name.replaceAll("[^\\w\\s\\-_]", "");


                if(excelTitle.compareTo(pageTitle)==0){
                    System.out.println("ok strings are same");
                }