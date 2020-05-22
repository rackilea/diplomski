class Vehicle {
        private Date date;
        private int nbOfVehicleArriving;

        public Vehicle(Date date, int nbOfVehicleArriving) {
            this.date = date;
            this.nbOfVehicleArriving = nbOfVehicleArriving;
        }

        public int getNbOfVehicleArriving() {
            return nbOfVehicleArriving;
        }

        public Date getDate() {
            return date;
        }       

    }


    class Planning {
        private Date date;
        private int nbOfallowedVehicles;

        public Planning(Date date, int nbOfallowedVehicles) {
            this.date = date;
            this.nbOfallowedVehicles = nbOfallowedVehicles;
        }

        public int getNbOfallowedVehicles() {
            return nbOfallowedVehicles;
        }
    }


    class Queue {
        private Date date;
        private int noOfVehiclesInQueue;

        public Queue(Date date, int noOfVehiclesInQueue) {
            this.date = date;
            this.noOfVehiclesInQueue = noOfVehiclesInQueue;
        }

        public int getNoOfVehiclesInQueue() {
            return noOfVehiclesInQueue;
        }

        @Override
        public String toString() {
            return "Queue [date=" + date + ", noOfVehiclesInQueue=" + noOfVehiclesInQueue + "]";
        }           

    }


    public class Demo {         

        public static void main(String[] args) {

            List<Vehicle> veh=new ArrayList<>();
            List<Planning> plan=new ArrayList<>();
            List<Queue> queue=new ArrayList<>();

            veh.add(new Vehicle(new Date("01/01/2018 00:00:00"), 12));
            veh.add(new Vehicle(new Date("01/01/2018 00:10:00"), 10));
            veh.add(new Vehicle(new Date("01/01/2018 01:00:00"), 5));
            veh.add(new Vehicle(new Date("01/01/2018 01:10:00"), 10));

            plan.add(new Planning(new Date("01/01/2018 00:00:00"), 2));
            plan.add(new Planning(new Date("01/01/2018 00:10:00"), 4));
            plan.add(new Planning(new Date("01/01/2018 01:00:00"), 6));

            for(int i=0;i<veh.size();i++) {

                int vehicleinpreviousqueue=(i!=0)?queue.get(i-1).getNoOfVehiclesInQueue():0;
                int vehiclearrving=veh.get(i).getNbOfVehicleArriving();
                int vehicleallowed=(i<veh.size()-1)?plan.get(i).getNbOfallowedVehicles():plan.get(i-1).getNbOfallowedVehicles();
                int vehicleinqueue=((vehicleinpreviousqueue+vehiclearrving-vehicleallowed)>0)?(vehicleinpreviousqueue+vehiclearrving-vehicleallowed):0;     


                queue.add(new Queue(veh.get(i).getDate(), vehicleinqueue));

            }

          for(Queue q:queue) System.out.println(q.toString());

        }

    }