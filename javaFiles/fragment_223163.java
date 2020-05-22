EnscribeFile p_origin = new EnscribeFile(file);
String first_record;
byte buffer[]; 

//First, charge all records and then purge the file content
ArrayList<byte[]> records = new ArrayList<byte[]>();
buffer = new byte[et.getRecordLength()];
p_origin.open(EnscribeOpenOptions.READ_WRITE,EnscribeOpenOptions.SHARED);
EnscribeFileAttributes et = p_origin.getFileInfo();
int aux_len = p_origin.read(buffer,et.getRecordLength());
while ( aux_len != EnscribeFile.POSITION_UNUSED )
{
    byte auxRecord[] = new byte[aux_len];
    System.arraycopy(buffer,0,auxRecord,0,et.getRecordLength());
    records.add(auxRecord);
    aux_len = p_origin.read(buffer,et.getRecordLength());
}
p_origin.purgeData();

//Second, modify first record
first_record = new String(records.get(0));
first_record = "XXX" + first_record.substring(3);
records.set(0,first_record.getBytes());

//Third, rewrite the records and close the file
Iterator<byte[]> i = records.iterator();
while( i.hasNext() )
{
    byte aux_byte[] = i.next();
    p_origin.write(aux_byte,aux_byte.length);
}

p_origin.close();