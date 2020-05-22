//  File schema
String outputFormat = "struct<";
for(int i=0;i<outputSchema.length;i++){
    outputFormat+=outputSchema[i]+":string,";
}
outputFormat+="lastRecordHash:string,currentHash:string>";
TypeDescription orcSchema = TypeDescription.fromString(outputFormat);

//  Initializes buffers
VectorizedRowBatch batch = orcSchema.createRowBatch();
ArrayList<BytesColumnVector> orcBuffers = new ArrayList<>(numFields+2);
for(int i=0;i<numFields+2;i++){
    BytesColumnVector bcv = (BytesColumnVector) batch.cols[i];
    bcv.initBuffer();
    orcBuffers.add(i, bcv);
}

...

//  Initializes writer
Writer writer=null;
try{
    writer = OrcFile.createWriter(new Path(hdfsUri+outputPath), OrcFile.writerOptions(conf).setSchema(orcSchema));
    partitionCounter++;
}
catch(IOException e){
    log.error("Cannot open hdfs file. Reason: "+e.getMessage());
    session.transfer(flowfile, hdfsFailure);
    return;
}

//  Writes content
String[] records = ...

for(int i=0;i<records.length;i++){
    fields = records[i].split(fieldSeparator);

    int row=batch.size++;

    //  Filling the orc buffers
    for(int j=0;j<numFields;j++){
        orcBuffers.get(j).setVal(row, fields[j].getBytes());
        hashDigest.append(fields[j]);
    }
    if (batch.size == batch.getMaxSize()) {
        try{
            writer.addRowBatch(batch);
            batch.reset();
        }
        catch(IOException e){
            log.error("Cannot write to hdfs. Reason: "+e.getMessage());
            return;
        }
    }         
}
if (batch.size != 0) {
    try{
        writer.addRowBatch(batch);
        batch.reset();
    }
    catch(IOException e){
        log.error("Cannot write to hdfs. Reason: "+e.getMessage());
        return;
    }
}
writer.close();