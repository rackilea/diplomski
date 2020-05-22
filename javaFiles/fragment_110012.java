try {
            Processor myProcessor = Manager.createProcessor( myMediaLocator );
            Format relax = myProcessor.getContentDescriptor().relax();
            if(relax instanceof VideoFormat) {
                double frameRate = ((VideoFormat)relax).getFrameRate();
            }
        } catch( NoProcessorException e ) {
        } catch( NotConfiguredError e ) {
        } catch( IOException e ) {
        }