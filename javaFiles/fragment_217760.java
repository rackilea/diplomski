Global.Init( this );
PDFHttpStream m_stream = new PDFHttpStream();
Document m_doc = new Document();
ReaderController m_vPDF = new ReaderController(this);
m_stream.open("http://maven.apache.org/maven-1.x/maven.pdf");
int ret = m_doc.OpenStream(m_stream, null);
if( ret == 0 ) {
   m_vPDF.open(m_doc);
   setContentView( m_vPDF );
}