private void test (int index){
        PhilosopherCard.lock.lock();
        int left = index-1;
        int right = index +1;
        if(index==0){
            left=piNumberOfPhilosophers-1;
        }
        if(index == piNumberOfPhilosophers-1){
            right = 0;
        }
        if((state[left]!="eating")&(state[right]!="eating")){
            state[index]="eating";
            status[index].signal();;
            }
        PhilosopherCard.lock.unlock();
    }