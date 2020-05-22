Queue<Patient> pq = new PriorityQueue<Patient>();
 Iterator<Patient> iter = pq.iterator();    
            while(iter.hasNext()){
                Patient current = iter.next();
                if(current.getName().equals(patientName)){

                    iter.remove();
                    }


                }