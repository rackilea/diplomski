class CustomizedScoreProvider extends CustomScoreProvider {

    public CustomizedScoreProvider(LeafReaderContext reader) {
            super(reader);
            // TODO Auto-generated constructor stub
        }

    public  float customScore(int doc, float subQueryScore,float valSrcScores[]){

     try {

         subQueryScore+=4; // I only added this for testing , 
     } catch(Exception e) { 
         e.printStackTrace();
            }
    return subQueryScore;
             }
    }

class CustomizedScoreQuery extends CustomScoreQuery{


public CustomizedScoreQuery(Query subQuery,IndexReader ireader) {
        super(subQuery);
        // TODO Auto-generated constructor stub
    }
public CustomizedScoreProvider getCustomScoreProvider (LeafReaderContext reader){
    CustomizedScoreProvider i=new CustomizedScoreProvider(reader);
     return (i);
}
}