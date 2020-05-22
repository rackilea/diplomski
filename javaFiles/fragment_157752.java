for(i=0;i<n;i++)
    {
       for(j=i;j<n;j++)
       {
          if(arrival[j+1] < arrival[j])
          {
                temp=deadline[j+1];
                deadline[j+1]=deadline[j];
                deadline[j]=temp;

                temp=job[j+1];
                job[j+1]=job[j];
                job[j]=temp;

                temp=burst[j+1];
                burst[j+1]=burst[j];
                burst[j]=temp;


                temp=arrival[j+1];
                arrival[j+1]=arrival[j];
                arrival[j]=temp; 
          }
       }
    }