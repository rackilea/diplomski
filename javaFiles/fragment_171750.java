public class Biblio {
           Biblio[] Tab; 
           static int i=0;
           public Biblio() {
                  Tab = new Biblio[5];
           }
          void insert(Biblio O){
                 Tab[i]=O;i++;
           }
      }