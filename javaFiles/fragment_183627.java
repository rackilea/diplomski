@Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        sb.delete(0, sb.length());
        if (localName.equalsIgnoreCase("channel")) {
            inChannel = true;
            newFeed = new Feed();
            itemList = new ArrayList<Item>();
        }
        if (inChannel) {            
            if (localName.equalsIgnoreCase("image")) {
                feedImage = new Image();
                inImage = true;
                return;
            }           
            else if (localName.equalsIgnoreCase("item")) {
                newItem = new Item();
                inItem = true;
                return;
            }

            if(inImage) { //set booleans for image elements
                if (localName.equalsIgnoreCase("title")) imgTitle = true;
                else if (localName.equalsIgnoreCase("link")) imgLink = true;
                else if (localName.equalsIgnoreCase("url")) imgURL = true;
                return;
            }           
            else if(inItem) { //set booleans for item elements
                if (localName.equalsIgnoreCase("title")) iTitle = true;
                else if (localName.equalsIgnoreCase("link")) iLink = true;
                else if (localName.equalsIgnoreCase("description")) iDescription = true;
                else if (localName.equalsIgnoreCase("author")) iAuthor = true;
                else if (localName.equalsIgnoreCase("category")) iCategory = true;
                else if (localName.equalsIgnoreCase("comments")) iComments = true;
                else if (localName.equalsIgnoreCase("guid")) iGuid = true;
                else if (localName.equalsIgnoreCase("pubdate")) iPubDate= true;
                else if (localName.equalsIgnoreCase("source")) iSource = true;
                return;
            } else { //set booleans for channel elements
                if (localName.equalsIgnoreCase("title")) fTitle = true;
                else if (localName.equalsIgnoreCase("link")) fLink = true;
                else if (localName.equalsIgnoreCase("description")) fDescription = true;
                else if (localName.equalsIgnoreCase("language")) fLanguage= true;
                else if (localName.equalsIgnoreCase("copyright")) fCopyright = true;
                else if (localName.equalsIgnoreCase("category")) fCategory = true;
                return;
            }
        }       
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(inChannel) {
            if(inImage) {
                if (localName.equalsIgnoreCase("title")) {
                    feedImage.setTitle(sb.toString());
                    sb.delete(0, sb.length());
                    imgTitle = false;
                    return;
                }
                else if (localName.equalsIgnoreCase("link")) {
                    feedImage.setLink(sb.toString());
                    sb.delete(0, sb.length());
                    imgLink = false;
                    return;
                }
                else if (localName.equalsIgnoreCase("url")) {
                    feedImage.setUrl(sb.toString());
                    sb.delete(0, sb.length());
                    imgURL = false;
                    return;
                }
                else return;
            } 
            else if(inItem) {
                if (localName.equalsIgnoreCase("item")) {
                    itemList.add(newItem);
                    newItem = null;
                    inItem = false;
                    return;
                } else if (localName.equalsIgnoreCase("title")) {
                    newItem.setTitle(sb.toString()); 
                    sb.delete(0, sb.length());
                    iTitle = false;
                    return;
                } else if (localName.equalsIgnoreCase("link")) {
                    newItem.setLink(sb.toString()); 
                    sb.delete(0, sb.length());
                    iLink = false;
                    return;
                } else if (localName.equalsIgnoreCase("description")) {
                    newItem.setDescription(sb.toString()); 
                    sb.delete(0, sb.length());
                    iDescription = false;
                    return;
                } else if (localName.equalsIgnoreCase("author")) {
                    newItem.setAuthor(sb.toString()); 
                    sb.delete(0, sb.length());
                    iAuthor = false;
                    return;
                } else if (localName.equalsIgnoreCase("category")) {
                    newItem.addCategory(sb.toString()); 
                    sb.delete(0, sb.length());
                    iCategory = false;
                    return;
                } else if (localName.equalsIgnoreCase("comments")) {
                    newItem.setComments(sb.toString());
                    sb.delete(0, sb.length());
                    iComments = false;
                    return;
                } /*else if (localName.equalsIgnoreCase("enclosure")) {
                     To be implemented later
                }*/ else if (localName.equalsIgnoreCase("guid")) {
                    newItem.setGuid(sb.toString()); 
                    sb.delete(0, sb.length());
                    iGuid = false;
                    return;
                } else if (localName.equalsIgnoreCase("pubDate")) {
                    newItem.setPubDate(sb.toString()); 
                    sb.delete(0, sb.length());
                    iPubDate = false;
                    return;
                }
            } 
            else {
                if(localName.equalsIgnoreCase("channel")) {
                    newFeed.setItems((ArrayList<Item>)itemList);
                    finalFeed = newFeed;
                    newFeed = null;                     
                    inChannel = false;
                    return;
                } else if(localName.equalsIgnoreCase("title")) {
                    newFeed.setTitle(currentValue); 
                    sb.delete(0, sb.length());
                    fTitle = false;
                    return;
                } else if(localName.equalsIgnoreCase("link")) {
                    newFeed.setLink(currentValue); 
                    sb.delete(0, sb.length());
                    fLink = false;
                    return;
                } else if(localName.equalsIgnoreCase("description")) {
                    newFeed.setDescription(sb.toString());
                    sb.delete(0, sb.length());
                    fDescription = false;
                    return;
                } else if(localName.equalsIgnoreCase("language")) {
                    newFeed.setLanguage(currentValue); 
                    sb.delete(0, sb.length());
                    fLanguage = false;
                    return;
                } else if(localName.equalsIgnoreCase("copyright")) {
                    newFeed.setCopyright(currentValue); 
                    sb.delete(0, sb.length());
                    fCopyright = false;
                    return;
                } else if(localName.equalsIgnoreCase("category")) {
                    newFeed.addCategory(currentValue); 
                    sb.delete(0, sb.length());
                    fCategory = false;
                    return;
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        sb.append(new String(ch, start, length));
    }