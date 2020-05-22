while(true) {
    try {
        userList.add((Personnel) ois.readObject()); 
    } catch (EOFException e) {
         // end of file reached
    };
}