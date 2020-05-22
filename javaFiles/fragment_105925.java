public class TxtExtr_AnatomyRegex {
     private String x;
     private Map<String,String> map= new LinkedHashMap<String,String>();
     private String [] seAnatomy=null;
     private ArrayList<String> Anatomy_arr = new ArrayList<String>();
     private ArrayList<List<String>> Anatomy_table2d = new      ArrayList<List<String>>();
     String el[]=null;
     Pattern Anatomy_pattern = null;
     Matcher atcherAnatomy_pattern = null;

     public TxtExtr_AnatomyRegex(String x,Map<String,String> map) {
        // TODO Auto-generated constructor stub
        x=this.x;
        map=this.map;

        Anatomy_pattern = Pattern.compile("Anatomy\\*(.*?Hiatal hernia[^\n]*)",Pattern.DOTALL);
        matcherAnatomy_pattern = Anatomy_pattern.matcher(x); /////////////////////////////////ERROR IS HERE

      //...put here your for and while stuff

      }//end of the constructur


      //... some methods ... you maybe also can do something of the loops in methods

  } //end of the class