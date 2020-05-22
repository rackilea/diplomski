ArrayList<Uporabnik> seznamUporabnikov=null;
//check if already in session before creating.  
if(session.getAttribute("seznamUporabnikov") == null) {        
    seznamUporabnikov = new ArrayList<Uporabnik>(); 
    //array which I want to display
    session.setAttribute("seznamUporabnikov", seznamUporabnikov);   
} else {
    seznamUporabnikov = 
                 (ArrayList<Uporabnik>)session.getAttribute("seznamUporabnikov");
}

if (request.getParameter("potrdi") != null) {
    seznamUporabnikov.add(uporabnik);
}


session.setAttribute("seznamUporabnikov", seznamUporabnikov);