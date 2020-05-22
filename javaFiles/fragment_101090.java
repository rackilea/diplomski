import java.util.*;
class Main {
  public static void main(String[] args) {
   String[] arr = {
            "room1", "10.11.2017", "17:00-18:00", "meeting event",
            "room2", "12.11.2017", "19:00-20:00", "meeting event",
            "room3", "20.11.2017", "20:00:21:00", "meeting event",
            "room1", "10.11.2017", "18:00-19:00", "meeting event",
            "room1", "15.11.2017", "10:00-11:00", "meeting event",
            "room2", "12.11.2017", "21:00-22:00", "meeting event",
            "room2", "12.11.2017", "22:00-23:00", "meeting event",
            "room3", "20.11.2017", "21:00:22:00", "meeting event",
            "room1", "10.11.2017", "19:00-20:00", "meeting event",
            "room4", "30.11.2017", "09:00-10:00", "meeting event"
    };

ArrayList<String> arr2 = new ArrayList<String>();

    String roomNumber= new String();
    String bookedDate = new String();
    String bookedTime = new String();
    String event = new String();
    // array to check if record is already checked. 
    boolean[] alreadyChecked = new boolean[arr.length/4];
    for (int i = 0; i < arr.length; i+=4) {
        roomNumber = arr[i];
        bookedDate = arr[i+1];
        bookedTime = arr[i+2];
        event = arr[i+3];
        // If record is already checked, continue
        if(alreadyChecked[i/4] == true)
          continue;

        for (int j = i + 4; j < arr.length; j+=4) {
                if (arr[i].equals(arr[j]) && arr[i+1].equals(arr[j+1]) && !arr[i+2].equals(arr[j+2]) && alreadyChecked[j/4] == false){
                    bookedTime = bookedTime + " , " + arr[j+2];
                    // Mark the record as checked
                    alreadyChecked[j/4] = true;
                } 
            }

        arr2.add(roomNumber +  " , " + bookedDate + " , " + bookedTime +  " , " + event);
        // mark the record as checked
        alreadyChecked[i/4] = true;
        }

    for (int k =  0; k <arr2.size(); k++) {
        System.out.println(arr2.get(k));
    }

  }
}