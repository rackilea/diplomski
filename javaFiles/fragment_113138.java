Vector rawVector = Superclass.somemethod(textfield.gettext);
Vector<String> paramVector = new Vector<String> ();

for(Object obj : rawVector)
{
   if(obj instanceof String)
      paramVector.add(obj);
}