public int compareTo(Patient p){

        int compareEmergency = ((Patient) p).getEmergencyLvl();

        int aux= compareEmergency - this.emergencyLvl;

        int compareIndex= ((Patient) p).getIndex();
        if(compareIndex>this.patIndx) aux=compareIndex-this.patIndx;
        return aux;    



        }