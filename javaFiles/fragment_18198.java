try {
            DatatypeFactory  dtFactory = DatatypeFactory.newInstance(); 
        } catch (DatatypeConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

Duration duration = dtFactory.newDuration("p0dt1h0m0s");