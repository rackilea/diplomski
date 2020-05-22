FileOutputStream fout= new FileOutputStream ( yourPathtowriteto );
BufferedOutputStream bout= new BufferedOutputStream (fout);
BufferedInputStream bin= new BufferedInputStream(stream);


int byte;
while ((byte=bin.read()) != -1)
{
     bout.write(byte_);
}
bout.close();
bin.close();