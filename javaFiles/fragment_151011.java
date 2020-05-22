//mmSocket is the socket i got from a bluetooth connection
//this is for sending an object
public void writeSerialized(){
        Object contact = new Contact("Allen", "Patterson", "256-369-241");
        try {
            ObjectOutputStream oos = new  ObjectOutputStream(mmSocket.getOutputStream());
            oos.writeObject(contact);
            oos.close();
        }catch(Exception e){
            Log.e(TAG, "Error ObjectOutputStream: "+e.getLocalizedMessage());
        }
    }