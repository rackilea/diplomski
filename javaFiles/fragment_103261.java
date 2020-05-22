@Override
protected void finalize()
{

    try{ this.close(); }
    finally{ super.finalize(); }

}