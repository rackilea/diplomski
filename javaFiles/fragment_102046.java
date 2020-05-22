int i =0;
        try{
            final StringBuilder builder = new StringBuilder();
            String Blank="";
            String Explanation="";
            String dizi[] = {"AIRLINE : ","COUNTRY : ","BEGAN OPERATION : ","AVERAGE AGE OF FLEET : ","PASSENGER VOLUME :","LAST FATAL ACCIDENT : ",
                    "FATAL ACCIDENTS LAST 10 YRS : ","FATAL ACCIDENTS LAST 20 YRS : ","EXPLANATION : "};

            Document doc = Jsoup.connect("http://www.planecrashinfo.com/accidents.htm").get();
            title = doc.title();
            Elements links = doc.select("td");

            // builder.append(title).append("\n");
            for (Element link : links) {
                if (i==dizi.length){
                    i=0;
                    Blank=":DENEME:";


                }else{
                    Blank="";

                }
                builder.append("\n").append(Blank+dizi[i]).append(link.text()+Explanation);
                Datas= builder.toString();





                i++;

            }

        }catch (Exception e){

            e.printStackTrace();
        }