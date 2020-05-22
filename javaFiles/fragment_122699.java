for (Element link : links) {



            if(link.text().contains("Arecibo Message"))//find the link with some texts
            {
                System.out.println("here is the element you need");
                System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());
            }


        }