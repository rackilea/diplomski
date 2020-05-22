import org.apache.lucene.index.{ Term, IndexReader }
import org.apache.lucene.search.{ TermQuery, Query }
import org.apache.lucene.search.function.{ CustomScoreProvider, CustomScoreQuery }

class CustomizedScoreProvider(reader: IndexReader) extends 
    CustomScoreProvider(reader) {

    protected override def customScore(doc: Int, 
        subQueryScore: Float, valSrcScores: Array[Float]): Float = {
        try {
            // subQueryScore is the default score you get from  
            // the original Query
            val currentDocument = reader.document(doc)

            // get the value of two field1, field2, 
            // make sure the two fields are stored since you have to retrieve the value
            val field1Value = currentDocument.get("field1")
            val field2Value = currentDocument.get("field2")

            // write your own logical to compute the extra score, assuming 0 here
            val extraScore = 0F

            // ignore the valSrcScores here, the original calculation      
            // is modifiedScore = subQueryScore*valSrcScores[0]*..
            subQueryScore + extraScore
        } catch {
            case _: Exception => subQueryScore
        }
    }
}

/**
 * Create a CustomScoreQuery over input subQuery.
 * @param subQuery the sub query whose scored is being customized. Must not be null.
 */
class CustomizedScoreQuery(val subQuery: Query, reader: IndexReader) 
    extends CustomScoreQuery(subQuery) {
    protected override def getCustomScoreProvider(reader: IndexReader) = {
        try {
            new CustomizedScoreProvider(reader)
        } catch {
            case _: Exception => super.getCustomScoreProvider(reader)
        }
    }
}


object CustomizedScoreQueryTest extends App {

    val termQuery = new TermQuery(new Term("field", "xxx"))
    // get indexSearch, indexReader and  wrap the original query
    ...
    val wrappedQuery = new CustomizedScoreQuery(termQuery, indexReader)
    val topDocs = indexSearch.search(wrappedQuery, 5)
    ...

}