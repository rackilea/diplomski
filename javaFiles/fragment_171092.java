public String save(){
   Ciclista c = new Ciclista();
   c.setNombre(this.nombre);
   c.setNacionalidad(this.nacionalidad);
   c.setEquipo(this.equipo);

   create(c);
   return "Administrador?faces-redirect=true";
}