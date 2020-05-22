public void write(DataOutput d) throws IOException
    {
      d.writeUTF(name);
      d.writeUTF(attribute);
      d.writeUTF(attType);
      d.writeUTF(condition);
      d.writeUTF(lines);
      ObjectWritable left=new ObjectWritable(BinaryTreeNode.class,leftChild);
      left.write(d);
      ObjectWritable right=new ObjectWritable(BinaryTreeNode.class,rightChild);
      right.write(d);
    }

    public void readFields(DataInput di) throws IOException
    {
      name=di.readUTF();
      attribute=di.readUTF();
      attType=di.readUTF();
      condition=di.readUTF();
      lines=di.readUTF();
      leftChild=(BinaryTreeNode) ObjectWritable.readObject(di, new Configuration());
      rightChild=(BinaryTreeNode) ObjectWritable.readObject(di, new Configuration());

    }