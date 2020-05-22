if("dad".equals(currentElementName) == true){
            logger.info("isStartElement: " + xmlsr.isStartElement());
            logger.info("Element BEGIN: " + currentElementName);
            xmlsr.skipElement();
            break;                  //the cure for IllegalStateException
        }