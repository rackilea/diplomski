final SimpleFeatureType TYPE = 
        DataUtilities.createType("Location",
            "location:Point:srid=4326," + // <- the geometry attribute: Point type
                    "name:String," + // <- a String attribute
                    "number:Integer" // a number attribute
    );