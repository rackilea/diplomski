for(byte[] eachkey : colUpdateKeys ){
    existingdata =  
             existingdata.withColumn(
                existingdata.col(Bytes.toString(eachkey)),
                "value from themetadatamap"
             );
}