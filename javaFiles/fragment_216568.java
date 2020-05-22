i think this will help you,

create two classes with getter setter methods

public class Ressources {

    private String id;
    private String key;
    private String name;
    private String lname;
    private String scope;
    private String qualifier;
    private String lang;
    private String version;
    private String date;
    private List<Mesures> msr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Mesures> getMsr() {
        return msr;
    }

    public void setMsr(List<Mesures> msr) {
        this.msr = msr;
    }

}

public class Mesures {

    private String key;
    private float val;
    private String frmt_val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    public String getFrmt_val() {
        return frmt_val;
    }

    public void setFrmt_val(String frmt_val) {
        this.frmt_val = frmt_val;
    }

}

then use this to Parse your JSON

String jsonl = "[{'id':7,'key':'integrationContinue:integrationContinue','name':'life Portlet','scope':'PRJ','qualifier':'TRK','date':'2012-03-26T10:10:22+0100','lname':'life Portlet','lang':'java','version':'1.0-SNAPSHOT','description':'','msr':[{'key':'ncloc','val':897.0,'frmt_val':'897'},{'key':'coverage','val':0.6,'frmt_val':'0,6%'}]}]";

Gson gson = new Gson();
Type collectionType = new TypeToken<List<Ressources>>() {
        }.getType();
List<Ressources> ressourcesList = gson.fromJson(jsonl, collectionType);

Ressources ressources = ressourcesList.get(0);
System.out.println("id :" + ressources.getId());
System.out.println("key :" + ressources.getKey());
System.out.println("name :" + ressources.getName());
System.out.println("scope :" + ressources.getScope());
System.out.println("qualifier :" + ressources.getQualifier());
System.out.println("date :" + ressources.getDate());
System.out.println("lname :" + ressources.getLname());
System.out.println("lang :" + ressources.getLang());
System.out.println("version :" + ressources.getVersion());
System.out.println("Mrs :");

List<Mesures> mrsList = ressources.getMsr();
for (int i = 0; i < mrsList.size(); i++) {
System.out.println("key :" + mrsList.get(i).getKey());
System.out.println("val :" + mrsList.get(i).getVal());
System.out.println("frmt_val :" + mrsList.get(i).getFrmt_val());
}


output:

id :7
key :integrationContinue:integrationContinue
name :life Portlet
scope :PRJ
qualifier :TRK
date :2012-03-26T10:10:22+0100
lname :life Portlet
lang :java
version :1.0-SNAPSHOT
Mrs :
key :ncloc
val :897.0
frmt_val :897
key :coverage
val :0.6
frmt_val :0,6%