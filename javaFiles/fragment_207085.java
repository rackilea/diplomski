package mypackage;

import java.io.*;
import java.util.*;
import org.apache.lucene.index.*;

public class Cloud {

    private String indexaddress;
    private int numTerms;

    private int max;
    private int sum;

    public Cloud(String indexaddress, int numTerms) {
        this.indexaddress = indexaddress;
        this.numTerms = numTerms;
        max = 0;
        sum = 0;
    }

    public List<TermInfo> getCloud() throws Exception {

        TermInfoQueue termQ = new TermInfoQueue(numTerms);

        IndexReader reader = IndexReader.open(new File(indexaddress));
        TermEnum terms = reader.terms();



        int minFreq = 0;
        while (terms.next()) {

            if (!terms.term().field().equals("keywords")) continue;

            if ( terms.docFreq() > minFreq) {
                if (termQ.size() >= numTerms)            // if tiq overfull
                {
                    termQ.pop();                 // remove lowest in tiq
                    termQ.put(new TermInfo(terms.term(), terms.docFreq()));
                    minFreq = ((TermInfo)termQ.top()).docFreq; // reset minFreq
                } else {
                    termQ.put(new TermInfo(terms.term(), terms.docFreq()));
                }
            }
        }

        terms.close();
        reader.close();

        ArrayList<TermInfo> res = new ArrayList<TermInfo>( termQ.size() );
        while ( termQ.size() > 0 ) {
            TermInfo ti = (TermInfo)termQ.pop();
            max = Math.max( max, ti.docFreq );
            sum += ti.docFreq;
            res.add( ti );
        }

        // Shuffles the results up, since a sorted cloud would be predictiable.
        //Collections.shuffle( res );

        return res;
      }

      public int getMaxFrequency() {
          return max;
      }
}

class TermInfo {

    TermInfo(Term t, int df) {
        term = t;
        docFreq = df;
    }

    public int docFreq;
    public Term term;
}

class TermInfoQueue extends org.apache.lucene.util.PriorityQueue {

    TermInfoQueue(int size) {
        initialize(size);
    }

    protected final boolean lessThan(Object a, Object b) {
        TermInfo termInfoA = (TermInfo)a;
        TermInfo termInfoB = (TermInfo)b;
        return termInfoA.docFreq < termInfoB.docFreq;
    }
}