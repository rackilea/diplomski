try{ 
      PrintWriter out=res.getWriter();
     String subcategory=req.getParameter("request_menu");
     System.out.println("Receive : "+subcategory); 
    JSONObject jobj=UserDelegate.reqFromTabForMenuBySCatg(subcategory);
       }
     if(jobj!=null){
     out.println(jobj); 
    }else{ 
   out.print("Sorry Not Available");
    }
    }catch(Exception e){ e.printStackTrace(); }