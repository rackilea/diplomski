public class tarea
{         
    List<input> datas = new ArrayList<input>();

     class input
     {
         public int profit;
         public int deadline;
         public int index1;
         public int index2;
         public int sum() {return index1+index2;}
        /**
         * @param profit
         * @param deadline
         */
        public input(int deadline, int profit)
        {
            super();
            this.profit = profit;
            this.deadline = deadline;
        } 

     }


     public void readData1()
     {
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(1,1));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
         this.datas.add(new input(10,1000));
     }


     public void readData2()
     {/*
         3 40
         2 1 35
         3 1 30
         4 3 25
         5 1 20
         6 3 15
         7 2 10 */

         this.datas.add(new input(3,40));
         this.datas.add(new input(1,35));
         this.datas.add(new input(1,30));
         this.datas.add(new input(3,25));
         this.datas.add(new input(1,20));
         this.datas.add(new input(3,15));
         this.datas.add(new input(2,10));
     }

     public void readData3()
     {/*
     2 30
     4099 1 35
     3059 2 25
     2098 1 40*/

         this.datas.add(new input(2,30));
         this.datas.add(new input(1,35));
         this.datas.add(new input(2,25));
         this.datas.add(new input(1,40));
     }



     @SuppressWarnings("unchecked")
    public void sortbyprofit(List<input> datas)
     {
         Collections.sort(datas, new Comparator() {

            public int compare(Object o1, Object o2)
            {
                if(((input)(o1)).profit < ((input)(o2)).profit)
                    return 1;
                else if(((input)(o1)).profit == ((input)(o2)).profit)
                    return 0;
                else return -1;
            }});
     }

     @SuppressWarnings("unchecked")
     public void sortbydeadline(List<input> datas)
      {
          Collections.sort(datas, new Comparator() {

             public int compare(Object o1, Object o2)
             {
                 if(((input)(o1)).deadline > ((input)(o2)).deadline)
                     return 1;
                 else if(((input)(o1)).deadline == ((input)(o2)).deadline)
                     return 0;
                 else return -1;
             }});
      }


     @SuppressWarnings("unchecked")
     public void sortbySum(List<input> datas)
      {
          Collections.sort(datas, new Comparator() {

             public int compare(Object o1, Object o2)
             {
                 if(((input)(o1)).sum() > ((input)(o2)).sum())
                     return 1;
                 else if(((input)(o1)).sum() == ((input)(o2)).sum())
                     return 0;
                 else return -1;
             }});
      }


    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        tarea tsk = new tarea();
        //tsk.readData1();
        //tsk.readData2();
        tsk.readData3();


        while (tsk.datas.size() > 0)
        {
            //sort by profit
            tsk.sortbyprofit(tsk.datas);
            int idx0 = 1;
            //assign index
            for (input data : tsk.datas)
            {
                data.index1 = idx0;
                idx0++;
            }

            //sort by deadline
            tsk.sortbydeadline(tsk.datas);
            int idx2 = 1;
            for (input data : tsk.datas)
            {
                data.index2 = idx2;
                idx2++;
            }

            //sort by sum and profit
            tsk.sortbySum(tsk.datas);

            List<input> tmpdatas = new ArrayList<input>();
            int valsum = tsk.datas.get(0).sum();
            for (input data : tsk.datas)
            {
                if (data.sum() == valsum)
                    tmpdatas.add(data);
            }            
            tsk.sortbyprofit(tmpdatas);

            //get the first one as result
            input thedata = tmpdatas.get(0);

            System.out.println("result ===> " + thedata.profit);

            tsk.datas.remove(thedata);
            tmpdatas = new ArrayList<input>();
            for (input data : tsk.datas)
            {
                data.deadline--;
                if (data.deadline > 0)
                    tmpdatas.add(data);
            }
            tsk.datas = tmpdatas;
        }


    }


}