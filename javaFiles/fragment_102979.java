@Override
public void removeRoom(String name){
    for (int i = 0; i < rooms.size(); i++) {
        if(name.equalsIgnoreCase(rooms.get(i).getName())){
            rooms.removeIf(r -> r.getName().equals(name));
            System.out.println("Removed !");
        }
    }
}