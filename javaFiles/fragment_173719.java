Semaphore mutex = new Semaphore(1);
Semaphore productCount = new Semaphre(0);

public producer(){     

mutex.acquire();  //entering critical section
    putItemIntoBuffer(item); //produce your item in the exclusive mode
    productCount.release();  //increase your product count
mutex.release();  //leave critical section

}

public consumer(){
mutex.acquire(); //entering critical section

if(productCount.availablePermits() > 0) //test if you have already poduced some items
{
   removeItemFromBuffer(item); //remove your item in the exclusive mode  
   productCount.acquire();     //decrease your item count
}

mutex.release(); //leave critical section
 }