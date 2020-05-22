public OggettoBase creaOggetto(OggettoType oggetto)
{
    String tipo = oggetto.getClass().getSimpleName().toString();
    IObjectCreator creator = Factory.GetObjectCreator(tipo);
    if(creator == null)
        return null;
    return creator.Create();
}

public interface IObjectCreator
{
    OggettoBase Create(); 
}

public CheckboxCreator:IObjectCreator
{
    public OggettoBase Create()
    {
        return new Checkbox();
    }
}

//Repeat for each type

public static Factory
{
    public IObjectCreator GetObjectCreator(string tipo)
    {
        IObjectCreator creator;
        switch(tipo)
        {
            case "CheckBoxType": creator = new CheckboxCreator(); break;
            ...
            default : System.out.println("Il tipo: "+tipo+" non esiste");
        }
        return creator;
}