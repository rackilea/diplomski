@Override
    public void readFields(DataInput in) throws IOException {
        str = in.readUTF();
        //some code for reading next pointer
        if (!"".equals(str)) {
            boolean existNext = in.readBoolean();
            if (existNext) {
                next = new Nikhil();
                next.readFields(in);
            }
        }
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(str);
        //some code for next
        //
        if (!"".equals(str)) {
            boolean existNext = null != next;
            out.writeBoolean(existNext);
            if (existNext) {
                next.write(out);
            }
        }
    }