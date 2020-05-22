//
// Dependencies
// ============
import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer
import org.apache.solr.common.SolrInputDocument

@Grapes([
    @Grab(group='org.apache.solr', module='solr-solrj', version='3.5.0'),
])

//
// Main
// =====
SolrServer server = new CommonsHttpSolrServer("http://localhost:8983/solr/");

new File(".").eachFileMatch(~/.*\.xml/) { 

    it.withReader { reader ->
        def xml = new XmlSlurper().parse(reader)

        xml.doc.each { 
            SolrInputDocument doc = new SolrInputDocument();

            it.field.each {
                doc.addField(it.@name.text(), it.text())
            }

            server.add(doc)
        }
    }

}

server.commit()