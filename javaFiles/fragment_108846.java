2- Install WordNet
    3- Go to Installed Directory and copied the WordNet Directory (in my case C:\Program Files (x86) was the Directory for WordNet Folder)
    4- Pasted it into my Java Project (under MyProject>WordNet)
    5- Making Path to the directory as:
       File f=new File("WordNet\\2.1\\dict");
       System.setProperty("wordnet.database.dir", f.toString());
    6- Got Synonyms as:

       public class TestJAWS{
              public static void main(String[] args){
                    String wordForm = "capacity";
                    //  Get the synsets containing the word form=capicity

                   File f=new File("WordNet\\2.1\\dict");
                   System.setProperty("wordnet.database.dir", f.toString());
                   //setting path for the WordNet Directory

                   WordNetDatabase database = WordNetDatabase.getFileInstance();
                   Synset[] synsets = database.getSynsets(wordForm);
                   //  Display the word forms and definitions for synsets retrieved

                   if (synsets.length > 0){
                      ArrayList<String> al = new ArrayList<String>();
                      // add elements to al, including duplicates
                      HashSet hs = new HashSet();
                      for (int i = 0; i < synsets.length; i++){
                         String[] wordForms = synsets[i].getWordForms();
                           for (int j = 0; j < wordForms.length; j++)
                           {
                             al.add(wordForms[j]);
                           }


                      //removing duplicates
                       hs.addAll(al);
                       al.clear();
                       al.addAll(hs);

                      //showing all synsets
                      for (int i = 0; i < al.size(); i++) {
                            System.out.println(al.get(i));
                      }
                   }
              }
              }
              else
              {
               System.err.println("No synsets exist that contain the word form '" + wordForm + "'");
              }
       }