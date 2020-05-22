ExtraMetaData emd = new ExtraMetaData(); //this my own class to carry the header and footer    

PDFMarkedContentExtractor markedContentExtractor = new PDFMarkedContentExtractor();
                markedContentExtractor.processPage(document.getPage(0));
                List<PDMarkedContent>  markedContents = markedContentExtractor.getMarkedContents();
                for (Iterator iterator = markedContents.iterator(); iterator.hasNext();) {
                    PDMarkedContent pdMarkedContent = (PDMarkedContent) iterator.next();
                    System.out.println(pdMarkedContent.getTag()+" --> "+pdMarkedContent.getContents()+ " "+pdMarkedContent.getProperties());
                    COSDictionary pdmcProperties = pdMarkedContent.getProperties();
                    if (pdmcProperties.containsKey("Subtype")) {
                        COSBase cosBase =  pdmcProperties.getDictionaryObject("Subtype");
                        if (((COSName)cosBase).getName().equalsIgnoreCase("Footer")) {
                            emd.setFooter(getContentAsString(pdMarkedContent));
                        }
                        if (((COSName)cosBase).getName().equalsIgnoreCase("Header")) {
                            emd.setHeader(getContentAsString(pdMarkedContent));
                        }           
                    }
                    if (pdmcProperties.containsKey("Attached")) {
                        COSArray cosArray = (COSArray) pdmcProperties.getDictionaryObject("Attached");
                        for (COSBase cosBase2 : cosArray) {
                            if (((COSName)cosBase2).getName().equalsIgnoreCase("Bottom")) {
                                emd.setFooter(getContentAsString(pdMarkedContent));
                            }
                            if (((COSName)cosBase2).getName().equalsIgnoreCase("Top")) {
                                emd.setHeader(getContentAsString(pdMarkedContent));
                            }           

                        }
                    }

                }