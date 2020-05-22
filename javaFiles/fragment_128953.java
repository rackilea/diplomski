public static void main(String args[]){
String line;
List<CarModel> cars = new ArrayList<>();
  try(Scanner sc = new Scanner(System.in)){
     while(sc.hasNextLine()){
     line = sc.nextLine();
     String[] arr = line.split(" ");
     if(arr[0].equalsIgnoreCase("Model")){
        cars.add(new CarModel(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2])));
      }else if(arr[0].equalsIgnoreCase("Finish"){
        break;
      }
    }
   }catch(ArrayIndexOutOfBoundsException ex){
     // do something here! 
   }catch(Exception ex){
     // do something here as well!
   }    
}