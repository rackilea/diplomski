...

@Key("artifacts") 
private Artifact[] artifacts;

public static class Artifact extends GenericJson {  
    @Key 
    private String type;
    @Key 
    private String photo_url;
    public Artifact() {} 
} 

@Key("_kmd") 
private KinveyMetaData meta;

...