class PaqueteDeDatos 
{
 String Nombre;
 String Apellido; 
 String Cedula; 
 String Direccion;
 String Telefono;
 String CorreoElectronico;
 String Intensivo1;
 String Intensivo2;

 public PaqueteDeDatos(String a, String b, String c, String d, String e, String f, String g, String h) 
 {
  Nombre = a;
  Apellido = b;
  Cedula = c;
  Direccion = d;
  Telefono = e;
  CorreoElectronico = f;
  Intensivo1 = g;
  Intensivo2 = h;
 }
 public String toString()
 {
  StringBuilder sb = new StringBuilder();
  sb.append(Nombre).append(" ")
    .append(Apellido).append(" ")
    .append(Cedula).append(" ")
    .append(Direccion).append(" ")
    .append(Telefono).append(" ")
    .append(CorreoElectronico).append(" ")
    .append(Intensivo1).append(" ")
    .append(Intensivo2).append(" ");
  return sb.toString();
 }
}