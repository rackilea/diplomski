public int recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta)
{ 
    int cont = 0;
    for(int i=0; i<this.getVisitantes().size(); i++)
    {
       if(p_fechaDesde.before(((Visitante)this.getVisitantes().get(i)).getFechaVisita()) && p_fechaHasta.after(((Visitante)this.getVisitantes().get(i)).getFechaVisita()))
        {
            cont++;
        }
    }
return cont;
}