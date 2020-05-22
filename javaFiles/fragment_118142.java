public Vector copi(Vector copy){
        Vector callp=new Vector();
         for(int i=0;i<copy.size();i++){
                copy.removeAll(Collections.singleton(null));
                Capaciter_n_objet cno1=null,cno=(Capaciter_n_objet) copy.get(i);
                cno1=new Capaciter_n_objet();
                cno1.capaiter_rest=cno.capaiter_rest;
                cno1.n_objet= (Vector)  cno.n_objet.clone();
                callp.add(cno1);
            }       
 return callp;           
 }