 
          ArrayList<String> cont =  (ArrayList)request.getAttribute("list");
          Iterator<String> itr = cont.iterator();
          while (itr.hasNext()) {
          String element = itr.next();
          out.println(element);