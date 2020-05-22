public void doIt( String inputFile, String outputFile, String strToFind, String message)
            throws IOException, COSVisitorException
        {
            // the document
            PDDocument doc = null;
            try
            {
                doc = PDDocument.load( inputFile );
                List pages = doc.getDocumentCatalog().getAllPages();
                for( int i=0; i<pages.size(); i++ )
                {
                    PDPage page = (PDPage)pages.get( i );
                    PDStream contents = page.getContents();
                    PDFStreamParser parser = new PDFStreamParser(contents.getStream() );
                    parser.parse();
                    List tokens = parser.getTokens();
                    for( int j=0; j<tokens.size(); j++ )
                    {
                        Object next = tokens.get( j );
                        if( next instanceof PDFOperator )
                        {
                            PDFOperator op = (PDFOperator)next;
                            //Tj and TJ are the two operators that display
                            //strings in a PDF
                            if( op.getOperation().equals( "Tj" ) )
                            {
                                //Tj takes one operator and that is the string
                                //to display so lets update that operator
                                COSString previous = (COSString)tokens.get( j-1 );
                                String string = previous.getString();
                                string = string.replaceFirst( strToFind, message );
                                previous.reset();
                                previous.append( string.getBytes() );
                            }
                            else if( op.getOperation().equals( "TJ" ) )
                            {
                                COSArray previous = (COSArray)tokens.get( j-1 );
                                for( int k=0; k<previous.size(); k++ )
                                {
                                    Object arrElement = previous.getObject( k );
                                    if( arrElement instanceof COSString )
                                    {
                                        COSString cosString = (COSString)arrElement;
                                        String string = cosString.getString();
                                        string = string.replaceFirst( strToFind, message );
                                        cosString.reset();
                                        cosString.append( string.getBytes() );
                                    }
                                }
                            }
                        }
                    }
                    //now that the tokens are updated we will replace the
                    //page content stream.
                    PDStream updatedStream = new PDStream(doc);
                    OutputStream out = updatedStream.createOutputStream();
                    ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
                    tokenWriter.writeTokens( tokens );
                    page.setContents( updatedStream );
                }
                doc.save( outputFile );
            }
            finally
            {
                if( doc != null )
                {
                    doc.close();
                }
            }
        }