Iterator<Document> i = documents.iterator();
        while(i.hasNext() && (verify == false) ) {
            Document a = i.next();
            if (!a.equals(doc)) {
                 System.out.println(" Wasn't found in the list" + doc);

            } else {
                System.out.println(" Was found in the list" + doc);
                verify = true;


            }

        }   
if (verify == false) documents.add(doc);