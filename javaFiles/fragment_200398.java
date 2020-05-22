String s = "accelaration";
        String s2 = "trash";
        MeasurementType t = null;

        try {
            t =MeasurementType.getMeasurement(s);
            t = MeasurementType.getMeasurement(s2); //throw ex
        }catch (RuntimeException e){
            //do something
        }