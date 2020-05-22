try // reflection
  {
   Field manufacturerField = android.os.Build.class
     .getDeclaredField("MANUFACTURER");
   manufacturerField.setAccessible(true);
   String manufacturerName = manufacturerField.get(
     android.os.Build.class).toString();
   System.out.println("manufacturerName: " + manufacturerName);

  } catch (Exception ex) {

   System.err
     .println("getManufacturerName, got an exception during getting Field : "
       + ex.toString());
  }