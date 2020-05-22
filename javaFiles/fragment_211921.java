ByteArrayOutputStream baos = new ByteArrayOutputStream();
   DataOutputStream dos = new DataOutputStream(baos);

   dos.writeInt(this.type);
   dos.writeDouble(this.localX);
   dos.writeDouble(this.localY);
   dos.writeBoolean(this.buttonDown);

   return baos.toByteArray();