public class BlobA extends BadDBDesign {
  @Lob @Column("col_a")
  @Type(type ="org.springframework.orm.hibernate3.support.BlobByteArrayType")
  private byte[] blobColA;
}

public class BlobB extends BadDBDesign {
  @Lob @Column("col_b")
  @Type(type ="org.springframework.orm.hibernate3.support.BlobByteArrayType")
  private byte[] blobColB;
}