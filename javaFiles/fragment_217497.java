Base b;
 if (info.getType().equals("REFERENCES")) {
    b=new References();
 } else if (info.getType().equals("LABELS")) {
    b=new Labels();
 } else if (info.getType().equals("STANDARDS")) {
    b=new Standards();
 } else {
   return;
 }
 b.setMessage(info.getMessage());
 b.setAutor(info.getAutor());
 Transaction t = session.beginTransaction();
 session.persist(b);
 t.commit();