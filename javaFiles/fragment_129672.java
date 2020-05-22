public static void main(String[] args)  {

  System.out.println(EnumUtils.getDescription(Enum1.class, "DELETE"));
  System.out.println(EnumUtils.getDescription(Enum2.class, "DELETE"));

  System.out.println(EnumUtils.getValue(Enum1.class, "CANCEL"));
  System.out.println(EnumUtils.getValue(Enum2.class, "APPEND"));

}