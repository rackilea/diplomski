String first=dis.readUTF();
String second=dis.readUTF();
int    third=dis.readInt();
if (buscar.compareTo(first)==0) {
                           System.out.println("Los datos completos del usuario son: "+first+" "+second+" que nació el "+third);
                           break;
                   }