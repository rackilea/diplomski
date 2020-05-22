public void endElement(String uri, String localName, String qName)
            throws SAXException {
  if (qName.equalsIgnoreCase("videos")) {
            // add it to the list
        /*} else if (qName.equalsIgnoreCase("success")) {
            cmd.setSuccess(tempVal);
        } else if (qName.equalsIgnoreCase("numberofvideos")) {
            cmd.setNumberOfVideos(tempVal);
        } else if (qName.equalsIgnoreCase("videos")) {
            cmd.setVideos(videos);
        } else if (qName.equalsIgnoreCase("video")) {
            cmd.setVideo(tempVal);*/
        } else if (qName.equalsIgnoreCase("videoname")) {
            cmd.setVideoName(tempVal);
        } else if (qName.equalsIgnoreCase("videourl")) {
            cmd.setVideoURL(tempVal);
            videos.add(cmd); //You only need store an instance of your Cmd 
        }
      }