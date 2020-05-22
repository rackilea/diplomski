public class SimpleObject implements KvmSerializable {

 private String name;
 private String address;
 private String id;

 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 @Override
 public Object getProperty(int pid) {
  // TODO Auto-generated method stub
  switch (pid) {
  case 0:
   return this.id;

  case 1:
   return this.name;

  case 2:
   return this.address;

  default:
   break;

  }

  return null;
 }

 @Override
 public int getPropertyCount() {
  // TODO Auto-generated method stub
  return 3;
 }

 @Override
 public void getPropertyInfo(int index, Hashtable htable, PropertyInfo info)                  {
  // TODO Auto-generated method stub

  switch (index) {
  case 0:
   info.type = PropertyInfo.STRING_CLASS;
   info.name = "id";
   break;
  case 1:
   info.type = PropertyInfo.STRING_CLASS;
   info.name = "name";
   break;
  case 2:
   info.type = PropertyInfo.STRING_CLASS;
   info.name = "address";
   break;

  }

 }

 @Override
 public void setProperty(int index, Object value) {
  // TODO Auto-generated method stub
  switch (index) {
  case 0:
   this.id = value.toString();
   break;
  case 1:
   this.name = value.toString();
   break;
  case 2:
   this.address = value.toString();
   break;

  }

 }

}