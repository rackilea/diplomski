Elements data = (Elements) jaxbUnmarshaller.unmarshal( file );
List<Aaa> aaas = data.getAaa();

for ( Aaa aaa : aaas )
{
    System.out.println( "aaa" + " " + aaa.getPosition() );
}
List<Bbb> bbbs = data.getBbb();
for ( Bbb bbb : bbbs )
{
    System.out.println( "bbb" + " " + bbb.getPosition() );
}